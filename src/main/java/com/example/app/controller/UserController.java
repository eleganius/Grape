package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.User;
import com.example.app.service.ArticleService;
import com.example.app.service.UserService;
import com.example.app.validation.AddUserGroup;

@Controller
@RequestMapping("/grape/users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	ArticleService articleService;

	@GetMapping("/{id}")
	public String show(
			@PathVariable Integer id,
			Model model) {
		model.addAttribute("title", "ユーザー詳細");
		model.addAttribute("user", userService.getUserByEmail(id));
		model.addAttribute("articleList", articleService.getArticleList());
		return "users/user";
	}

	@GetMapping("/addUser")
	public String addUserGet(Model model) {
		model.addAttribute("title", "ユーザー登録画面");
		model.addAttribute("user", new User());
		return "users/addUser";
	}

	@PostMapping("/addUser")
	public String addUserPost(@Validated(AddUserGroup.class) @ModelAttribute User user,
			Errors errors, Model model) {

		if (!user.getEmail().equals(user.getEmailConf())) {
			errors.rejectValue("emailConf", "error.email.inequal");
		}

		if (errors.hasErrors()) {
			return "users/addUser";
		}

		return "redirect:/grape/articleList";

	}

}
