package com.example.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.User;
import com.example.app.service.UserService;
import com.example.app.validation.LoginGroup;

@Controller
@RequestMapping("/grape")
public class LoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String loginGet(Model model) {
		model.addAttribute("title", "ログイン画面");
		User user = new User();
		user.setEmail("taro@example.com");
		user.setLoginPass("pass1");
		model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(
			@RequestParam String email,
			@RequestParam String loginPass,
			@Validated(LoginGroup.class) User user,
			Errors errors,
			HttpSession session) throws Exception {

		if (errors.hasErrors()) {
			return "login";
		}

		if (!userService.isCollectEmailAndLoginPass(user.getEmail(), user.getLoginPass())) {
			errors.rejectValue("email", "error.incorrect_email_loginPass");
			return "login";
		}

		session.setAttribute("loginUser", userService.getUserByEmail(email));
		return "redirect:/grape/articles/articleList";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/grape/login";
	}

}
