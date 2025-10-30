package com.study.spring.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<PostDto> postView() {
//		List<PostDto> postView = postdao.listDao();
		return postdao.listDao();
	}
	
//	localhost:808/api/test?name=홍길동&age=30
	@GetMapping("/api/test")
	public String requestParam(
			@RequestParam("name") String name,
			@RequestParam("age") String age
			){
		
		return "hello, request param, i am " + name + ", age : " + age;
	}
	
	@GetMapping("/api/view/{name}/{age}")
	public String pathParam(
			@PathVariable("name") String name,
			@PathVariable("age") String age
			) {
		
		return "hello, request param, i am " + name + ", age : " + age;
	}
	
	@GetMapping("/api/dtest")
	public String dtoTest(
			@ModelAttribute TestDto dto
			) {
		return "hello, request param, i am " + dto.name + ", age : " + dto.age;
	}
}
