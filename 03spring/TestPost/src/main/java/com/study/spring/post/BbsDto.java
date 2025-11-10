package com.study.spring.post;


import java.sql.Timestamp;

import lombok.Data;

@Data
public class BbsDto {
	Long id;
	String name;
	String title;
	String content;
	Timestamp created_at;
}
