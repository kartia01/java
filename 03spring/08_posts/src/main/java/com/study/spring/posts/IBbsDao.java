package com.study.spring.posts;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IBbsDao {

	@Select("select * from posts order by id desc")
	List<BbsDto> findAll();

}
