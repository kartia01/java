package com.study.spring.jdbc_bbs;

import java.util.List;

public interface IBbsDAO {
	public List<BbsDTO> listDAO(); // list
	public Integer countDAO();     // count 데이터 갯수 null
	public BbsDTO viewtDAO(String id); // view 글 내용
	public int writeDAO(String writer, String title, String content);  // 글 작성
	public int deleteDAO(String id);  // 글 삭제
}
