package com.study.spring.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.study.spring.board.Dto.BoardDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.service.BoardService;

@RestController
public class BoardController {

	@Autowired
	BoardService boardservice;

	@GetMapping("/api2")
	public String root() {
		return "boardtest";
	}

	@GetMapping("/api2/board")
	public List<Board> getBoardList() {
		return boardservice.getBoardList();
	}

	@GetMapping("/api2/boarddto")
	public List<BoardDto> getBoardDto() {
		return boardservice.getBoardDto();
	}
	
	public Board getBoardView(@PathVariable("id") Long id) {
		return boardservice.getBoard(id);
	}
}
