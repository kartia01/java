package com.study.spring.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.product.dto.AddToCartRequest;
import com.study.spring.product.dto.CartDto;
import com.study.spring.product.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	@Autowired
	CartService cartService;

	// 장바구니 조회
	@GetMapping("/{memberId}")
	public CartDto getCart(@PathVariable("memberId") Long memberId) {
		return cartService.getCart(memberId);
	}

	// 장바구니에 상품 추가
	@PostMapping
	public CartDto addToCart(@RequestBody AddToCartRequest request) {
		return cartService.addToCart(request);
	}

	// 장바구니 아이템 수량 변경
	@PutMapping("/item/{cartItemId}")
	public CartDto updateCartItemQuantity(
			@PathVariable("cartItemId") Long cartItemId,
			@RequestParam("quantity") Integer quantity) {
		return cartService.updateCartItemQuantity(cartItemId, quantity);
	}

	// 장바구니 아이템 삭제
	@DeleteMapping("/item/{cartItemId}")
	public CartDto removeFromCart(@PathVariable("cartItemId") Long cartItemId) {
		return cartService.removeFromCart(cartItemId);
	}

	// 장바구니 비우기
	@DeleteMapping("/{memberId}")
	public void clearCart(@PathVariable("memberId") Long memberId) {
		cartService.clearCart(memberId);
	}
}
