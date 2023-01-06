package com.example.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.User;

@Controller
@RequestMapping("/grape")
public class UserController {

	@GetMapping("/addUser")
	public String addUserGet(Model model) {
		model.addAttribute("title", "ユーザー登録画面");
		model.addAttribute("user", new User());
		return "users/addUser";
	}

	@PostMapping("/addUser")
	public String addUserPost(@Valid @ModelAttribute("user") User user,
			Errors errors, Model model) {

		//バリデーション
		if (errors.hasErrors()) {
			// エラー内容の確認
			List<ObjectError> objList = errors.getAllErrors();
			for (ObjectError obj : objList) {
				System.out.println(obj.toString());
			}
			return "users/addUser";
		}

		return "redirect:/grape/articleList";

	}

}
