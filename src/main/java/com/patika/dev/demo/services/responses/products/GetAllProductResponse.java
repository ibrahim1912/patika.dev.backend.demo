package com.patika.dev.demo.services.responses.products;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllProductResponse {

	private int productId;

	private String productName;

	private double price;

	private Date expirationDate;
}
