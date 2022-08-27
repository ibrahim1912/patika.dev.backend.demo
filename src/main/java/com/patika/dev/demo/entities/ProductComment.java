package com.patika.dev.demo.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_comments")
@Builder
public class ProductComment {
//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_comment_id")
	private int productCommentId;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="comment_date")
	private Date commentDate;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	

}