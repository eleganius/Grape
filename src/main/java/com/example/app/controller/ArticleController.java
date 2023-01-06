package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grape")
public class ArticleController {

	@GetMapping("/articleList")
	public String showAll(Model model) {
		model.addAttribute("title", "トップ画面");
		return "articles/articleList";
	}

}
