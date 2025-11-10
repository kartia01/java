package com.study.spring.posts;

import java.security.Timestamp;

import lombok.Data;

@Data
public class PostBbsDto {
	Long id;
	String name;
	String title;
	String content;
	Timestamp created_at;
}
