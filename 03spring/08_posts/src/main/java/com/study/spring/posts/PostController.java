package com.study.spring.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	IBbsDao dao;
	
	@GetMapping("/")
	public String bbsRoot() {
		return "bbs";
	}
	
	@GetMapping("/bbs/list")
	public List<BbsDto> listPost(){
		return dao.findAll();
	}
	
	public void createPosts() {
		
	}
}
