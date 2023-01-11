package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.example.app.validation.AddUserGroup;
import com.example.app.validation.LoginGroup;

import lombok.Data;

@Data
public class User {

	//DBフィールド
	private Integer id;
	private String avatar;

	@NotBlank(groups = { AddUserGroup.class, LoginGroup.class })
	@Email(groups = { AddUserGroup.class })
	private String email;

	@NotBlank(groups = { AddUserGroup.class })
	private String emailConf;

	@NotBlank(groups = { AddUserGroup.class, LoginGroup.class })
	@Length(min = 8, max = 64, groups = { AddUserGroup.class })
	private String loginPass;

	@NotBlank(groups = { AddUserGroup.class })
	private String name;

	@Size(max = 100, groups = { AddUserGroup.class })
	private String introduction;

	private Date created;
	private Date updated;

	//例外フィールド
	private Follow follow;

}
