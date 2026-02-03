package com.study.spring.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.study.spring.hospital.dto.MyCommentDto;
import com.study.spring.hospital.entity.H_comment;

@Repository
public interface CommentRepository extends JpaRepository<H_comment, Integer> {

	@Query("""
			select c.c_content, c.created_at, u.name, u.id, c.created_at, r_id, c.c_id
			from h_comment c
			join h_user u on c.h_user_id = u.id
			join h_review r on c.h_user_id = r.h_user_id
			""")
	List<MyCommentDto> findAllCommentByIdDesc();
}
