package com.patika.dev.demo.services.abstracts;

import java.sql.Date;
import java.util.List;

import com.patika.dev.demo.services.responses.productComments.GetAllProductCommentResponse;

public interface ProductCommentService {

	
	public List<GetAllProductCommentResponse> getAllCommentsByProductId(int productId);

	public List<GetAllProductCommentResponse> getAllCommentsByUserId(int userId);

	public List<GetAllProductCommentResponse> getAllCommentsByProductIdAndCommentDate(int productId, Date startCommentDate, Date endCommentDate);

	public List<GetAllProductCommentResponse> getAllCommentsByUserIdAndCommentDate(int userId, Date startCommentDate, Date endCommentDate);

	
}
