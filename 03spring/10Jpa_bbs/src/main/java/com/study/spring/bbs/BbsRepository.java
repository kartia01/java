package com.study.spring.bbs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BbsRepository extends JpaRepository<Bbs, Long>{
	
	//	jpa query method
	List<Bbs> findAllByOrderByNameDesc();

}
