package com.example.app.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class User {

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

}
