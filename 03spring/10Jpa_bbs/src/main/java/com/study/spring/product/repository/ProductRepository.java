package com.study.spring.product.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p order by p.id desc")
	List<Product> findAllOrderByIdDesc();

	@Query("select p from Product p order by p.id desc")
	Page<Product> findAllWithPage(Pageable pageable);

	@Query("select p from Product p where p.name like %:keyword%")
	List<Product> findByNameContaining(@Param("keyword") String keyword);

	@Query("select p from Product p where p.stock > 0 order by p.id desc")
	List<Product> findAvailableProducts();
}
