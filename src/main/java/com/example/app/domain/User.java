package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class User {

	//DBフィールド
	private Integer id;

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

	private String avatar;
	private Date created;
	private Date updated;

	//例外フィールド
	//private Follow follow;

}
