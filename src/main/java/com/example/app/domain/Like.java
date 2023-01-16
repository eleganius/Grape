package com.example.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Like {

	//DBフィールド
	private Integer id;
	private Integer user_id;
	private Integer article_id;
	private Date createdAt;

}
