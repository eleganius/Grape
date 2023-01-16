package com.example.app.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
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

	private Date createdAt;
	private Date updatedAt;
	private String status;

	//JOINフィールド
	private User user;
	private int likeCount;
	private boolean likeIsDone;
	private int commentCount;
	private List<Comment> comment;

}
