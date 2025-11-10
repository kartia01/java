package com.study.spring.posts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PostController {

	@Autowired
	IPostBbsDao dao;

	@GetMapping("/")
	public String bbsRoot() {
		return "bbs";
	}

	@GetMapping("/post")
	public List<PostBbsDto> Postlist() {
		return dao.findAll();
	}

	@GetMapping("/post/list")
	public PostBbsDto viewData(@RequestParam("id") Long id) {
		log.info("view" + id);

		return dao.findById(id);
	}

	@PostMapping("/post")
	public void Postcreate(@RequestBody PostBbsDto request) {
		log.info("title : " + request.title + ", name : " + request.name + ", content : " + request.content);
		dao.Postcreate(request);
	}

	@PutMapping("/post/modify")
	public ResponseEntity<String> PostModify(@RequestParam("id") Long id, @RequestBody PostBbsDto request) {
		request.setId(id);
		int updated = dao.update(request);
		if (updated > 0) {
			return ResponseEntity.ok("update success");
		} else {
			return ResponseEntity.badRequest().body("update failed");
		}
	}

	@DeleteMapping("/post/delete")
	public ResponseEntity<String> delete(@RequestParam("id") Long id) {
		int deleted = dao.delete(id);
		if (deleted > 0) {
			return ResponseEntity.ok("delete success");
		} else {
			return ResponseEntity.badRequest().body("delete failed");
		}
	}
}
