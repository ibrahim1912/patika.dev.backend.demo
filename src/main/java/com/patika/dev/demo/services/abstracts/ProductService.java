package com.patika.dev.demo.services.abstracts;

import java.util.List;

import com.patika.dev.demo.services.responses.products.GetAllProductResponse;

public interface ProductService {

	public List<GetAllProductResponse> getAllExpiredProducts();

	public List<GetAllProductResponse> getAllNotExpiredProducts();

	public List<GetAllProductResponse> getAllProductsWithExpiredIsNull();
}
