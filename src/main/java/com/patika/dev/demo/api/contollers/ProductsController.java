package com.patika.dev.demo.api.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patika.dev.demo.services.abstracts.ProductService;
import com.patika.dev.demo.services.responses.products.GetAllProductResponse;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	
	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/getallexpiredproducts")
	public List<GetAllProductResponse> getAllExpiredProducts(){
		return this.productService.getAllExpiredProducts();
	}
	
	@GetMapping("/getallnotexpiredproducts")
	public List<GetAllProductResponse> getAllNotExpiredProducts(){
		return this.productService.getAllNotExpiredProducts();
	}

	@GetMapping("/getallproductswithexpiredisnull")
	public List<GetAllProductResponse> v(){
		return this.productService.getAllProductsWithExpiredIsNull();
	}

}