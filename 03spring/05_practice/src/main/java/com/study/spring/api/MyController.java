package com.study.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	IPostDao postdao;
	
	@GetMapping("/")
	public String root() {
		return "hello RESTful API";
	}
	
	@GetMapping("/api/posts")
	public List<PostDto> postView(){
		return postdao.listDao();
	}
	
	@GetMapping("/api/test")
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") String age
			) {
		return "hello, request param, i am " + name + ", age : " + age;
	}
}
