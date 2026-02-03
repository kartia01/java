package com.study.spring.product.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.spring.product.dto.ProductDto;
import com.study.spring.product.entity.Product;
import com.study.spring.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	// 상품 목록 조회
	public List<ProductDto> getProductList() {
		return productRepository.findAllOrderByIdDesc().stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}

	// 페이징 처리된 상품 목록
	public Page<ProductDto> getProductPageList(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return productRepository.findAllWithPage(pageable).map(this::toDto);
	}

	// 상품 상세 조회
	public ProductDto getProduct(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));
		return toDto(product);
	}

	// 상품 등록
	public ProductDto createProduct(ProductDto dto) {
		Product product = Product.builder()
				.name(dto.getName())
				.description(dto.getDescription())
				.price(dto.getPrice())
				.stock(dto.getStock())
				.imageUrl(dto.getImageUrl())
				.build();
		return toDto(productRepository.save(product));
	}

	// 상품 수정
	public ProductDto updateProduct(Long id, ProductDto dto) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다."));

		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setPrice(dto.getPrice());
		product.setStock(dto.getStock());
		product.setImageUrl(dto.getImageUrl());

		return toDto(productRepository.save(product));
	}

	// 상품 삭제
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	// 상품 검색
	public List<ProductDto> searchProducts(String keyword) {
		return productRepository.findByNameContaining(keyword).stream()
				.map(this::toDto)
				.collect(Collectors.toList());
	}

	// Entity -> DTO 변환
	private ProductDto toDto(Product product) {
		return ProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.stock(product.getStock())
				.imageUrl(product.getImageUrl())
				.createdAt(product.getCreatedAt())
				.build();
	}
}
