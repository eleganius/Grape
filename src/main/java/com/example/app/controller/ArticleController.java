package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Article;
import com.example.app.service.ArticleService;

@Controller
@RequestMapping("/grape")
public class ArticleController {

	@Autowired
	private ArticleService service;

	@GetMapping("/articleList")
	public String showAll(Model model) {
		model.addAttribute("title", "トップ画面");
		model.addAttribute("articleList", service.getArticleList());
		return "articles/articleList";
	}

	@GetMapping("/article/{id}")
	public String show(
			@PathVariable Integer id,
			Model model) {
		model.addAttribute("title", "投稿詳細");
		Article article = service.getArticleById(id);
		model.addAttribute("article", article);
		return "articles/article";
	}

}
