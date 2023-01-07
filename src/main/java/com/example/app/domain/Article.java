package com.example.app.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

	//DBフィールド
	private Integer id;
	private Integer userId;
	private String image;
	private String bodyText;
	private Date created;

	//例外フィールド
	private User user;
}
