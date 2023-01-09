package com.example.app.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Like {

	public Like(Integer likeCount) {
		this.likeCount = likeCount;
	}

	//DBフィールド
	private Integer id;
	private Integer user_id;
	private Integer article_id;
	private Date created;

	//例外フィールド
	private Integer likeCount;
	private Boolean done;

}
