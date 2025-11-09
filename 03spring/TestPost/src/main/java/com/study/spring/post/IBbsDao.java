package com.study.spring.post;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IBbsDao {

	@Select("select * from posts order by id desc")
	List<BbsDto> findAll();

	@Select("select * from posts where id=#{id}")
	BbsDto findById(Long id);

	@Insert("insert into posts(name,title,content,created_at) values (#{name},#{title},#{content},now())")
	void create(BbsDto request);

	@Update("update posts set title=#{title}, name=#{name}, content=#{content} where id=#{id}")
	int update(BbsDto request);

	@Delete("delete from posts where id=#{id}")
	int delete(Long id);
}
