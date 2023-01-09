package com.example.app.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	public Comment(Integer id, String body, Date created, Integer commentCount, User user) {
		this.id = id;
		this.body = body;
		this.created = created;
		this.commentCount = commentCount;
		this.user = user;
	}

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
