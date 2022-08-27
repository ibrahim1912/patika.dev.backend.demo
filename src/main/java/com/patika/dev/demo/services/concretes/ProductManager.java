package com.patika.dev.demo.services.concretes;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patika.dev.demo.entities.Product;
import com.patika.dev.demo.repositories.ProductRepository;
import com.patika.dev.demo.services.abstracts.ProductService;
import com.patika.dev.demo.services.responses.products.GetAllProductResponse;

@Service
public class ProductManager implements ProductService {

	private ProductRepository productRepository;

	@Autowired
	public ProductManager(ProductRepository productRepository) {
		this.productRepository = productRepository;
		
	}

	@Override
	public List<GetAllProductResponse> getAllExpiredProducts() {

		List<Product> result = this.productRepository.findAll();
		List<GetAllProductResponse> response = result.stream()
				.map(product -> GetAllProductResponse.builder()
						.productId(product.getProductId())
						.productName(product.getProductName())
						.price(product.getPrice())
						.expirationDate(product.getExpirationDate() == null ? null : product.getExpirationDate())
						.build())
				.filter(product -> product.getExpirationDate()!= null)
				.filter(product -> product.getExpirationDate().before(new Date(System.currentTimeMillis())))
				.collect(Collectors.toList());

		return response;
	}

	@Override
	public List<GetAllProductResponse> getAllNotExpiredProducts() {
		
		List<Product> result = this.productRepository.findAll();
		List<GetAllProductResponse> response = result.stream()
				.map(product -> GetAllProductResponse.builder()
						.productId(product.getProductId())
						.productName(product.getProductName())
						.price(product.getPrice())
						.expirationDate(product.getExpirationDate() == null ? null : product.getExpirationDate())
						.build())
				.filter(product -> product.getExpirationDate()!= null)
				.filter(product -> product.getExpirationDate().after(new Date(System.currentTimeMillis())))
				.collect(Collectors.toList());
		
		return response;
		
	}

	@Override
	public List<GetAllProductResponse> getAllProductsWithExpiredIsNull() {
		List<Product> result = this.productRepository.findAll();
		List<GetAllProductResponse> response = result.stream()
				.map(product -> GetAllProductResponse.builder()
						.productId(product.getProductId())
						.productName(product.getProductName())
						.price(product.getPrice())
						.expirationDate(product.getExpirationDate() == null ? null : product.getExpirationDate())
						.build())
				.filter(product -> product.getExpirationDate()== null)
				.collect(Collectors.toList());
		
		return response;
	}

}
