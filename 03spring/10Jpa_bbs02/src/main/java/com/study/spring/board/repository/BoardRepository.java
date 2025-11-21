package com.study.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study.spring.board.Dto.BoardDto;
import com.study.spring.board.entity.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

	@Query("""
			select b
			from Board b
			order by
			b.id desc
			""")
	List<Board> findAllOrderByDesc();

	@Query("""
			select new com.study.spring.board.dto.BoardDto(
			b.id,
			b.title,
			b.name,
			b.createdAt
			)
			from Board b
			order by b.id desc
			""")
	List<BoardDto> findAllBoardDto();

}
