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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Login;
import com.example.app.domain.User;
import com.example.app.login.LoginAuthority;
import com.example.app.login.LoginStatus;
import com.example.app.service.UserService;
import com.example.app.validation.LoginGroup;

@Controller
@RequestMapping("/user")
public class UserLoginController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String login(Model model) {
		Login login = new Login();
		login.setEmail("taro@example.com");
		login.setLoginPass("password");
		model.addAttribute(login);
		//model.addAttribute(new Login());
		return "login-user";
	}

	@PostMapping("/login")
	public String login(
			HttpSession session,
			@Validated(LoginGroup.class) Login login,
			Errors errors) throws Exception {

		User user = userService.getUserByEmail(login.getEmail());
		if (user == null ||
				user.getStatus().equals("DEL") ||
				!login.isCorrectPassword(user.getLoginPass())) {
			errors.rejectValue("email", "error.incorrect_email_loginPass");
		}

		if (errors.hasErrors()) {
			return "login-user";
		}

		LoginStatus loginStatus = new LoginStatus(user.getId(),
				user.getName(), user.getEmail(), LoginAuthority.USER);
		session.setAttribute("loginStatus", loginStatus);
		return "redirect:/article/list";
	}

	@GetMapping("/logout")
	public String logout(
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		session.removeAttribute("loginStatus");
		redirectAttributes.addFlashAttribute("message", "ログアウトしました。");
		return "redirect:/user/login";
	}

}
