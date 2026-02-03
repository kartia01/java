package com.study.spring.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.hospital.dto.MyCommentDto;
import com.study.spring.hospital.repository.CommentRepository;

@RestController
public class CommentController {

	@Autowired
	CommentRepository cmrepository;
	
	@GetMapping("/api/commentlist")
	public List<MyCommentDto> getListComment(){
		return cmrepository.findAllCommentByIdDesc();
	}
}
