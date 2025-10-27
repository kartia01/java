package com.study.spring.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IBbsDao {
	// 전체 글 목록
	public List<BbsDto> listDao();
	// 게시글 개수
	public int countDao();
	// 단일 글 조회
	public BbsDto viewDao(String id);
	// 글 작성
	public int writeDao(String writer, String title, String content);
	// 글 삭제
	public int deleteDao(String id);
}
