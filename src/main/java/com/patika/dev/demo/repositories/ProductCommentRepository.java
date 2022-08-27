package com.patika.dev.demo.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patika.dev.demo.entities.ProductComment;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Integer> {

	List<ProductComment> findByProduct_ProductId(int productId);

	List<ProductComment> findByProduct_ProductIdAndCommentDateBetween(int productId, Date startCommentDate,
			Date endCommentDate);

	List<ProductComment> findByUser_UserId(int userId);

	List<ProductComment> findByUser_UserIdAndCommentDateBetween(int userId, Date startCommentDate, Date endCommentDate);
}
