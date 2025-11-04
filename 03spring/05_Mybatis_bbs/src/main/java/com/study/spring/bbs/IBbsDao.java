package com.study.spring.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IBbsDao {
	// 전체 글 목록
	@Select("select * from simple_bbs order by id desc")
	public List<BbsDto> listDao();

	//	 게시글 개수
	@Select("select count(*) from simple_bbs")
	public int countDao();
	
	// 단일 글 조회
	@Select("select * from simple_bbs where id = #{0}")
	public BbsDto viewDao(String id);
	
	// 글 작성
	@Insert("insert into simple_bbs (writer,title,content) values (#{param1}, #{param2}, #{param3})")
	public int writeDao(String writer, String title, String content);
	
	// 글 삭제
	@Delete("delete from simple_bbs where id = #{0}")
	public int deleteDao(String id);
}
