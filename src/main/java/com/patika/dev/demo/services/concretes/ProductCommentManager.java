package com.patika.dev.demo.services.concretes;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patika.dev.demo.entities.ProductComment;
import com.patika.dev.demo.repositories.ProductCommentRepository;
import com.patika.dev.demo.services.abstracts.ProductCommentService;
import com.patika.dev.demo.services.responses.productComments.GetAllProductCommentResponse;

@Service
public class ProductCommentManager implements ProductCommentService {

	private ProductCommentRepository productCommentRepository;

	@Autowired
	public ProductCommentManager(ProductCommentRepository productCommentRepository) {

		this.productCommentRepository = productCommentRepository;
	}

	@Override
	public List<GetAllProductCommentResponse> getAllCommentsByProductId(int productId) {

		List<ProductComment> productCommentList = this.productCommentRepository.findByProduct_ProductId(productId);

		List<GetAllProductCommentResponse> response = productCommentList.stream()
				.map(comment -> GetAllProductCommentResponse.builder().comment(comment.getComment())
						.commentDate(comment.getCommentDate()).build())
				.collect(Collectors.toList());

		return response;

	}

	@Override
	public List<GetAllProductCommentResponse> getAllCommentsByUserId(int userId) {
		List<ProductComment> productCommentList = this.productCommentRepository.findByUser_UserId(userId);

		List<GetAllProductCommentResponse> response = productCommentList.stream()
				.map(comment -> GetAllProductCommentResponse.builder().comment(comment.getComment())
						.commentDate(comment.getCommentDate()).build())
				.collect(Collectors.toList());

		return response;
	}

	@Override
	public List<GetAllProductCommentResponse> getAllCommentsByProductIdAndCommentDate(int productId,
			Date startCommentDate, Date endCommentDate) {
		List<ProductComment> productCommentList = this.productCommentRepository
				.findByProduct_ProductIdAndCommentDateBetween(productId, startCommentDate, endCommentDate);

		List<GetAllProductCommentResponse> response = productCommentList.stream()
				.map(comment -> GetAllProductCommentResponse.builder().comment(comment.getComment())
						.commentDate(comment.getCommentDate()).build())
				.collect(Collectors.toList());

		return response;
	}

	@Override
	public List<GetAllProductCommentResponse> getAllCommentsByUserIdAndCommentDate(int userId, Date startCommentDate,
			Date endCommentDate) {
		List<ProductComment> productCommentList = this.productCommentRepository
				.findByUser_UserIdAndCommentDateBetween(userId, startCommentDate, endCommentDate);

		List<GetAllProductCommentResponse> response = productCommentList.stream()
				.map(comment -> GetAllProductCommentResponse.builder().comment(comment.getComment())
						.commentDate(comment.getCommentDate()).build())
				.collect(Collectors.toList());

		return response;
	}

}
