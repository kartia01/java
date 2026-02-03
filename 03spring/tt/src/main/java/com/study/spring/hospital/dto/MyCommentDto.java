package com.study.spring.hospital.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class MyCommentDto {
	private int c_id;
	private int r_id;
	private String id;
	private String name;
	private String c_content;
	private LocalDateTime createdAt; 
}
