package com.study.spring.jdbc_bbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {

	@Autowired
	IBbsDAO dao;
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "index";
	}
	
	
}
