package com.study.spring.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.spring.product.entity.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

	@Query("select ci from CartItem ci where ci.cart.id = :cartId")
	List<CartItem> findByCartId(@Param("cartId") Long cartId);

	@Query("select ci from CartItem ci where ci.cart.id = :cartId and ci.product.id = :productId")
	Optional<CartItem> findByCartIdAndProductId(@Param("cartId") Long cartId, @Param("productId") Long productId);

	@Query("""
			select ci from CartItem ci
			join fetch ci.product
			where ci.cart.id = :cartId
			""")
	List<CartItem> findByCartIdWithProduct(@Param("cartId") Long cartId);
}
