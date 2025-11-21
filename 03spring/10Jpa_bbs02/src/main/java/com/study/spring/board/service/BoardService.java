package com.study.spring.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.spring.board.Dto.BoardDto;
import com.study.spring.board.entity.Board;
import com.study.spring.board.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	BoardRepository boardrepository;

	public List<Board> getBoardList() {
		return boardrepository.findAllOrderByDesc();
	}

	public List<BoardDto> getBoardDto() {
		// TODO Auto-generated method stub
		return boardrepository.findAllBoardDto();
	}

	public Board getBoard(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
