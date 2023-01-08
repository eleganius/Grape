package com.example.app.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

	public Comment(Integer id, String body, Date created, User user) {
		super();
		this.id = id;
		this.body = body;
		this.created = created;
		this.user = user;
	}

	//DBフィールド
	private Integer id;
	private Integer userId;
	private Integer articleId;
	private String body;
	private Date created;
	private Date updated;

	//例外フィールド
	private User user;

}
