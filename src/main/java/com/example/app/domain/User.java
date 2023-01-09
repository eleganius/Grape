package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	public User(Integer id, String avatar, @NotBlank String name) {
		this.id = id;
		this.avatar = avatar;
		this.name = name;
	}

	public User(Integer id, String avatar, @NotBlank String name, @Size(max = 100) String introduction, Follow follow) {
		this.id = id;
		this.avatar = avatar;
		this.name = name;
		this.introduction = introduction;
		this.follow = follow;
	}

	//DBフィールド
	private Integer id;
	private String avatar;

	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Length(min = 8, max = 64)
	private String loginPass;

	@NotBlank
	private String name;

	@Size(max = 100)
	private String introduction;

	private Date created;
	private Date updated;

	//例外フィールド
	private Follow follow;

}
