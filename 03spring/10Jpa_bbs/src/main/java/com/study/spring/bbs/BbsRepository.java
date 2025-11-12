package com.study.spring.bbs;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long> {

	// jpa query method
	List<Bbs> findAllByOrderByIdDesc();

	// 페이지
//	Page<Bbs> findAll(Pageable pageable);

	Page<Bbs> findByTitleContaining(String title, Pageable pageable);

	Page<Bbs> findByTitleContainingOrNameContaining(String title, String name, Pageable pageable);

//	Page<Bbs> findByTitleContaining(String title, Pageable pageable);

}
