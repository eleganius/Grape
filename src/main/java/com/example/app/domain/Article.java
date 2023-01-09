package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

	public Article(Integer id, Integer userId, String image, String caption, Date created, User user, Like like,
			Comment comment) {
		this.id = id;
		this.userId = userId;
		this.image = image;
		this.caption = caption;
		this.created = created;
		this.user = user;
		this.like = like;
		this.comment = comment;
	}

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
