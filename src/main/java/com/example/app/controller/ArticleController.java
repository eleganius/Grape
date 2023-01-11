package com.example.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Article;
import com.example.app.service.ArticleService;

@Controller
@RequestMapping("/grape/articles")
public class ArticleController {

	@Autowired
	private ArticleService service;

	@GetMapping("/articleList")
	public String list(
			HttpSession session,
			Model model) throws Exception {
		model.addAttribute("title", "トップ画面");
		List<Article> articleList = service.getArticleList();
		System.out.println(articleList);
		model.addAttribute("articleList", articleList);
		//session.getAttribute("loginUser");
		return "articles/articleList";
	}

	@GetMapping("/{id}")
	public String show(
			@PathVariable Integer id,
			Model model) {
		model.addAttribute("title", "投稿詳細");
		Article article = service.getArticleById(id);
		model.addAttribute("article", article);
		return "articles/article";
	}

	@GetMapping("/addArticle")
	public String addArticleGet(Model model) {
		model.addAttribute("title", "投稿作成画面");
		model.addAttribute("article", new Article());
		return "articles/addArticle";
	}

	@PostMapping("/addArticle")
	public String addArticlePost(@Valid Article article,
			Errors errors, Model model) {

		//バリデーション
		if (errors.hasErrors()) {
			// エラー内容の確認
			List<ObjectError> objList = errors.getAllErrors();
			for (ObjectError obj : objList) {
				System.out.println(obj.toString());
			}
			return "articles/addArticle";
		}

		return "redirect:/grape/articleList";
	}

}
