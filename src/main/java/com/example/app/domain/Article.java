package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Article {

	//DBフィールド
	private Integer id;
	private Integer userId;
	private String image;

	@NotBlank
	@Size(max = 100)
	private String caption;

	private Date created;
	private Date updated;
	private Integer status;

	//例外フィールド
	private User user;
	private Like like;
	private Comment comment;

}
