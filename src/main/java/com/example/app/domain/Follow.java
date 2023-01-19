package com.example.app.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Follow {

	//DBフィールド
	private Integer id;
	private Integer followingId;
	private Integer followeeId;
	private Date createdAt;

	//JOINフィールド
	private List<User> userList;

}
