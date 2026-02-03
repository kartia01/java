package com.study.spring.product.dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDto {

	private Long id;
	private Long memberId;
	private String memberName;
	private List<CartItemDto> items;
	private BigDecimal totalPrice;
	private Integer totalQuantity;
}
