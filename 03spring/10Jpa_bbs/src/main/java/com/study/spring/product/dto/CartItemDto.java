package com.study.spring.product.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemDto {

	private Long id;
	private Long productId;
	private String productName;
	private BigDecimal productPrice;
	private String productImageUrl;
	private Integer quantity;
	private BigDecimal totalPrice;
}
