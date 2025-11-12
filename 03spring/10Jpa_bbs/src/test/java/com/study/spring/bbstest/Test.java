package com.study.spring.bbstest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Test {

	@Autowired
	BbsRepository bbsRepository;

	@GetMapping("/")
	public String root() {
		return "hi";
	}

	@GetMapping("/api/bbs")
	public List<Bbs> bbsList() {
		return bbsRepository.findAllByOrderByIdDesc();
	}
	
	@GetMapping("/api/bbs/{id}")
	public Optional<Bbs> bbsView(@PathVariable("id") Long id) {
		return bbsRepository.findById(id);
	}

	@PostMapping("/api/bbs")
	public Bbs bbscreate(@RequestBody BbsDto req) {
		Bbs bbs = Bbs.builder().name(req.getName()).title(req.getTitle()).content(req.getContent()).build();

		return bbsRepository.save(bbs);
	}

	@PutMapping("/api/bbs/{id}")
	public void bbsUpdate(@PathVariable("id") Long id, @RequestBody BbsDto req) {
		Optional<Bbs> view = bbsRepository.findById(id);
		log.info("정보확인" + view.toString());

		if (view.isEmpty()) {
			log.info("자료가 없습니다");
		} else {
			Bbs entity = view.get();
			entity.setName(req.getName());
			entity.setTitle(req.getTitle());
			entity.setContent(req.getContent());

			bbsRepository.save(entity);
			log.info("수정완료");
		}
	}

	@DeleteMapping("/api/bbs/{id}")
	public ResponseEntity<?> bbsdelete(@PathVariable("id") Long id) {
		boolean bbs = bbsRepository.existsById(id);
		if (!bbs) {
			return ResponseEntity.notFound().build();
		}

		bbsRepository.deleteById(id);
		return ResponseEntity.ok("삭제완료");
	}
}
