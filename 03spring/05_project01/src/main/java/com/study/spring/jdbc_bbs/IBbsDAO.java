package com.study.spring.jdbc_bbs;

import java.util.List;

public interface IBbsDAO {
	public List<BbsDTO> listDAO();
	public Integer countDAO();
	public BbsDTO viewDAO(String id);
	public int writeDAO(String writer, String title, String content);
	public int deleteDAO(String id);
}
