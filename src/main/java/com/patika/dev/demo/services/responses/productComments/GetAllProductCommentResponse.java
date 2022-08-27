package com.patika.dev.demo.services.responses.productComments;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAllProductCommentResponse {

	private String comment;
	private Date commentDate;
}
