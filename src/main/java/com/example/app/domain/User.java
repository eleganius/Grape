package com.example.app.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.app.validation.AddUserGroup;
import com.example.app.validation.EditUserGroup;
import com.example.app.validation.LoginGroup;

import lombok.Data;

@Data
public class User {

	//DBフィールド
	private Integer id;
	private String avatar;

	@NotBlank(groups = { AddUserGroup.class, EditUserGroup.class })
	private String name;

	@NotNull(groups = { AddUserGroup.class, EditUserGroup.class })
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	@NotBlank(groups = { AddUserGroup.class, EditUserGroup.class, LoginGroup.class })
	@Email(groups = { AddUserGroup.class, EditUserGroup.class })
	private String email;

	@NotBlank(groups = { AddUserGroup.class, EditUserGroup.class })
	private String emailConf;

	@NotBlank(groups = { AddUserGroup.class, EditUserGroup.class, LoginGroup.class })
	@Length(min = 8, max = 64, groups = { AddUserGroup.class, EditUserGroup.class })
	private String loginPass;

	@Size(max = 140, groups = { AddUserGroup.class, EditUserGroup.class })
	private String introduction;

	private Date createdAt;
	private Date updatedAt;
	private String status;

	//JOINフィールド
	private int followingCount;
	private int followeeCount;
	private boolean followIsDone;

}
