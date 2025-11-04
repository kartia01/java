package com.study.spring.store;

import lombok.Data;

@Data
public class MenuDto {
	long id;
	String name;
	int price;
	long store_id;
}
