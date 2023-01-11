package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

	@NotNull
	private Integer status;

	//例外フィールド
	private User user;
	private Like like;
	private Comment comment;

	//tagへ
	private String wineName;
	private Integer evaluation;
	private Integer color;
	private Integer year;
	private String country;
	private String breed;
	private String importer;
	private Integer price;

}
