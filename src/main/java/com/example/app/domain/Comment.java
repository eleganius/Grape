package com.example.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {

	//DBフィールド
	private Integer id;
	private Integer userId;
	private Integer articleId;
	private String body;
	private Date created;

	//例外フィールド
	private Integer commentCount;
	private User user;

}
