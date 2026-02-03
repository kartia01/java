package com.study.spring.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartRequest {

	private Long memberId;
	private Long productId;
	private Integer quantity;
}
