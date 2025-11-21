package com.study.spring.board.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoardDto {
	private Long id;
	private String title;
	private String name;
	private LocalDateTime createdAt;
}
