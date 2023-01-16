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

import com.example.app.domain.Admin;
import com.example.app.domain.Login;
import com.example.app.login.LoginAuthority;
import com.example.app.login.LoginStatus;
import com.example.app.service.AdminService;
import com.example.app.validation.AdminLoginGroup;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	@Autowired
	AdminService service;

	@GetMapping("/login")
	public String login(Model model) {
		Login login = new Login();
		login.setLoginId("haruko");
		login.setLoginPass("password");
		model.addAttribute(login);
		//model.addAttribute(new Login());
		return "login-admin";
	}

	@PostMapping("/login")
	public String login(
			HttpSession session,
			@Validated(AdminLoginGroup.class) Login login,
			Errors errors) throws Exception {

		Admin admin = service.getAdminByLoginId(login.getLoginId());
		if (admin == null ||
				!login.isCorrectPassword(admin.getLoginPass())) {
			errors.rejectValue("loginId", "error.incorrect_id_loginPass");
		}

		if (errors.hasErrors()) {
			return "login-admin";
		}

		LoginStatus loginStatus = new LoginStatus(admin.getId(),
				admin.getName(), admin.getLoginId(), LoginAuthority.ADMIN);
		session.setAttribute("loginStatus", loginStatus);
		return "redirect:/admin/user/list";
	}

	@GetMapping("/logout")
	public String logout(
			HttpSession session,
			RedirectAttributes redirectAttributes) {
		session.removeAttribute("loginStatus");
		redirectAttributes.addFlashAttribute("message", "ログアウトしました。");
		return "redirect:/admin/login";
	}

}
