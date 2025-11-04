package com.study.spring.jdbc_bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class BbsDAO implements IBbsDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<BbsDTO> listDAO() {
		System.out.println("글 리스트 listDAO");
		log.info(null);
		return null;
	}

	@Override
	public Integer countDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BbsDTO viewtDAO(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int writeDAO(String writer, String title, String content) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDAO(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
