package com.example.app.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Follow {

	//DBフィールド
	private Integer id;
	private Integer followerId;
	private Integer followeeId;
	private Date createdAt;

	//JOINフィールド
	private User user;

}
