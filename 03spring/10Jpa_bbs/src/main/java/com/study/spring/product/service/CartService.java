package com.study.spring.product.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.spring.member.entity.Member;
import com.study.spring.member.repository.MemberRepository;
import com.study.spring.product.dto.AddToCartRequest;
import com.study.spring.product.dto.CartDto;
import com.study.spring.product.dto.CartItemDto;
import com.study.spring.product.entity.Cart;
import com.study.spring.product.entity.CartItem;
import com.study.spring.product.entity.Product;
import com.study.spring.product.repository.CartItemRepository;
import com.study.spring.product.repository.CartRepository;
import com.study.spring.product.repository.ProductRepository;

@Service
@Transactional
public class CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	CartItemRepository cartItemRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	MemberRepository memberRepository;

	// 장바구니 조회
	public CartDto getCart(Long memberId) {
		Cart cart = cartRepository.findByMemberIdWithItems(memberId)
				.orElseThrow(() -> new RuntimeException("장바구니를 찾을 수 없습니다."));
		return toCartDto(cart);
	}

	// 장바구니에 상품 추가
	public CartDto addToCart(AddToCartRequest request) {
		// 장바구니 조회 또는 생성
		Cart cart = cartRepository.findByMemberId(request.getMemberId())
				.orElseGet(() -> createCart(request.getMemberId()));

		// 상품 조회
		Product product = productRepository.findById(request.getProductId())
				.orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));

		// 이미 장바구니에 있는 상품인지 확인
		CartItem existingItem = cartItemRepository
				.findByCartIdAndProductId(cart.getId(), request.getProductId())
				.orElse(null);

		if (existingItem != null) {
			// 수량 증가
			existingItem.setQuantity(existingItem.getQuantity() + request.getQuantity());
			cartItemRepository.save(existingItem);
		} else {
			// 새 아이템 추가
			CartItem newItem = CartItem.builder()
					.cart(cart)
					.product(product)
					.quantity(request.getQuantity())
					.build();
			cartItemRepository.save(newItem);
		}

		return getCart(request.getMemberId());
	}

	// 장바구니 아이템 수량 변경
	public CartDto updateCartItemQuantity(Long cartItemId, Integer quantity) {
		CartItem cartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new RuntimeException("장바구니 아이템을 찾을 수 없습니다."));

		if (quantity <= 0) {
			cartItemRepository.delete(cartItem);
		} else {
			cartItem.setQuantity(quantity);
			cartItemRepository.save(cartItem);
		}

		return getCart(cartItem.getCart().getMember().getId());
	}

	// 장바구니 아이템 삭제
	public CartDto removeFromCart(Long cartItemId) {
		CartItem cartItem = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new RuntimeException("장바구니 아이템을 찾을 수 없습니다."));

		Long memberId = cartItem.getCart().getMember().getId();
		cartItemRepository.delete(cartItem);

		return getCart(memberId);
	}

	// 장바구니 비우기
	public void clearCart(Long memberId) {
		Cart cart = cartRepository.findByMemberId(memberId)
				.orElseThrow(() -> new RuntimeException("장바구니를 찾을 수 없습니다."));

		List<CartItem> items = cartItemRepository.findByCartId(cart.getId());
		cartItemRepository.deleteAll(items);
	}

	// 새 장바구니 생성
	private Cart createCart(Long memberId) {
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));

		Cart cart = Cart.builder()
				.member(member)
				.build();
		return cartRepository.save(cart);
	}

	// Cart Entity -> CartDto 변환
	private CartDto toCartDto(Cart cart) {
		List<CartItemDto> items = cart.getCartItems().stream()
				.map(this::toCartItemDto)
				.collect(Collectors.toList());

		BigDecimal totalPrice = items.stream()
				.map(CartItemDto::getTotalPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		Integer totalQuantity = items.stream()
				.mapToInt(CartItemDto::getQuantity)
				.sum();

		return CartDto.builder()
				.id(cart.getId())
				.memberId(cart.getMember().getId())
				.memberName(cart.getMember().getName())
				.items(items)
				.totalPrice(totalPrice)
				.totalQuantity(totalQuantity)
				.build();
	}

	// CartItem Entity -> CartItemDto 변환
	private CartItemDto toCartItemDto(CartItem item) {
		Product product = item.getProduct();
		BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));

		return CartItemDto.builder()
				.id(item.getId())
				.productId(product.getId())
				.productName(product.getName())
				.productPrice(product.getPrice())
				.productImageUrl(product.getImageUrl())
				.quantity(item.getQuantity())
				.totalPrice(totalPrice)
				.build();
	}
}
