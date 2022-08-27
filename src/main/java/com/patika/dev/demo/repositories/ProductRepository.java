package com.patika.dev.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patika.dev.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	
}
