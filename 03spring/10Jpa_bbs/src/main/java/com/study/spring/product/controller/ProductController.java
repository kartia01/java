package com.study.spring.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.product.dto.ProductDto;
import com.study.spring.product.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	// 상품 목록 조회
	@GetMapping
	public List<ProductDto> getProductList() {
		return productService.getProductList();
	}

	// 페이징 처리된 상품 목록
	@GetMapping("/page")
	public Page<ProductDto> getProductPageList(
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size) {
		return productService.getProductPageList(page, size);
	}

	// 상품 상세 조회
	@GetMapping("/{id}")
	public ProductDto getProduct(@PathVariable("id") Long id) {
		return productService.getProduct(id);
	}

	// 상품 등록
	@PostMapping
	public ProductDto createProduct(@RequestBody ProductDto dto) {
		return productService.createProduct(dto);
	}

	// 상품 수정
	@PutMapping("/{id}")
	public ProductDto updateProduct(
			@PathVariable("id") Long id,
			@RequestBody ProductDto dto) {
		return productService.updateProduct(id, dto);
	}

	// 상품 삭제
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
	}

	// 상품 검색
	@GetMapping("/search")
	public List<ProductDto> searchProducts(@RequestParam("keyword") String keyword) {
		return productService.searchProducts(keyword);
	}
}
