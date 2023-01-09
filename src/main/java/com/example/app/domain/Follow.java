package com.example.app.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {

	public Follow(Integer followerCount, Integer followeeCount) {
		this.followerCount = followerCount;
		this.followeeCount = followeeCount;
	}

	//DBフィールド
	private Integer id;
	private Integer followerId;
	private Integer followeeId;
	private Date created;

	//例外フィールド
	private Integer followerCount;
	private Integer followeeCount;
	private Boolean done;
	private User user;

}
