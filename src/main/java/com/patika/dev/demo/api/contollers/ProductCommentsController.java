package com.patika.dev.demo.api.contollers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.patika.dev.demo.services.abstracts.ProductCommentService;
import com.patika.dev.demo.services.responses.productComments.GetAllProductCommentResponse;

@RestController
@RequestMapping("/api/productcomments")
public class ProductCommentsController {


	private ProductCommentService productCommentService;
	
	@Autowired
	public ProductCommentsController(ProductCommentService productCommentService) {
		this.productCommentService = productCommentService;
	}

	
	@GetMapping("/getallcommentsbyproductid")
	public List<GetAllProductCommentResponse> getAllCommentsByProductId(@RequestParam int productId){
		return this.productCommentService.getAllCommentsByProductId(productId);
	}
	
	@GetMapping("/getallcommentsbyuserid")
	public List<GetAllProductCommentResponse> getAllCommentsByUserId(@RequestParam int userId){
		return this.productCommentService.getAllCommentsByUserId(userId);
	}
	
	@GetMapping("/getallcommentsbyproductidandcommentdate")
	public List<GetAllProductCommentResponse> getAllCommentsByProductIdAndCommentDate(@RequestParam int productId,Date startCommentDate,Date endCommentDate){
		return this.productCommentService.getAllCommentsByProductIdAndCommentDate(productId,startCommentDate,endCommentDate);
	}
	
	@GetMapping("/getallcommentsbyuseridandcommentdate")
	public List<GetAllProductCommentResponse> getAllCommentsByUserIdAndCommentDate(@RequestParam int userId,Date startCommentDate,Date endCommentDate){
		return this.productCommentService.getAllCommentsByUserIdAndCommentDate(userId,startCommentDate,endCommentDate);
	}
	

}
