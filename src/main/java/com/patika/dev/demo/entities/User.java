package com.patika.dev.demo.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name",length = 50)
	private String firstName;
	
	@Column(name="last_name",length = 50)
	private String lastName;
	
	@Column(name="email",length = 50)
	private String email;
	
	@Column(name="phone",length = 15)
	private String phone;
	
	@OneToMany(mappedBy = "user")
	List<ProductComment> productComments;
}
