package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.example.app.validation.AddUserGroup;
import com.example.app.validation.LoginGroup;

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

	public User(
			@NotBlank(groups = { AddUserGroup.class, LoginGroup.class }) @Email(groups = AddUserGroup.class) String email,
			@NotBlank(groups = AddUserGroup.class) String emailConf,
			@NotBlank(groups = { AddUserGroup.class,
					LoginGroup.class }) @Length(min = 8, max = 64, groups = AddUserGroup.class) String loginPass,
			@NotBlank(groups = AddUserGroup.class) String name,
			@Size(max = 100, groups = AddUserGroup.class) String introduction) {
		this.email = email;
		this.emailConf = emailConf;
		this.loginPass = loginPass;
		this.name = name;
		this.introduction = introduction;
	}

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
