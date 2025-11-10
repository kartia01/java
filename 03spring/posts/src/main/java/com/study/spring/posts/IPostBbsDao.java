package com.study.spring.posts;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IPostBbsDao {

	@Select("select * from posts order by id desc")
	List<PostBbsDto> findAll();

	@Select("select * from posts where id=#{id}")
	PostBbsDto findById(Long id);

	@Insert("insert into posts(name, title, content,created_at) values (#{name}, #{title}, #{content},now())")
	void Postcreate(PostBbsDto request);

	@Update("update posts set title=#{title}, name=#{name}, content=#{content} where id=#{id}")
	int update(PostBbsDto request);

	@Delete("delete from posts where id=#{id}")
	int delete(Long id);

}
