package com.example.app.domain;

import javax.validation.constraints.NotBlank;

import org.mindrot.jbcrypt.BCrypt;

import com.example.app.validation.AdminLoginGroup;
import com.example.app.validation.LoginGroup;

import lombok.Data;

@Data
public class Login {

	@NotBlank(groups = { LoginGroup.class })
	private String email;

	@NotBlank(groups = { AdminLoginGroup.class })
	private String loginId;

	@NotBlank(groups = { LoginGroup.class, AdminLoginGroup.class })
	private String loginPass;

	public boolean isCorrectPassword(String hashedPassword) {
		return BCrypt.checkpw(loginPass, hashedPassword);
	}

}