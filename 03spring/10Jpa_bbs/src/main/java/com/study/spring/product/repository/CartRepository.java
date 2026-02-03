package com.study.spring.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.product.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query("select c from Cart c where c.member.id = :memberId")
	Optional<Cart> findByMemberId(@Param("memberId") Long memberId);

	@Query("""
			select c from Cart c
			left join fetch c.cartItems ci
			left join fetch ci.product
			where c.member.id = :memberId
			""")
	Optional<Cart> findByMemberIdWithItems(@Param("memberId") Long memberId);
}
