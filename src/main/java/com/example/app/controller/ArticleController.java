package com.example.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Article;
import com.example.app.login.LoginStatus;
import com.example.app.service.ArticleService;
import com.example.app.service.CommentService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	private static final int NUM_PER_PAGE = 6;

	@Autowired
	ArticleService service;

	@Autowired
	CommentService commentService;

	@GetMapping("/list")
	public String list(
			HttpSession session,
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) throws Exception {
		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");

		int totalPages = service.getTotalPages(NUM_PER_PAGE);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);
		model.addAttribute("articleList",
				service.getArticleListByPage(page, NUM_PER_PAGE, loginStatus.getId()));
		return "list-article";
	}

	@GetMapping("/show/{id}")
	public String show(
			HttpSession session,
			@PathVariable Integer id,
			Model model) throws Exception {

		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");

		Article article = service.getArticleById(id, loginStatus.getId());
		model.addAttribute("article", article);
		return "show-article";
	}

	@GetMapping("/add")
	public String addArticleGet(Model model) throws Exception {
		//radioボタン初期値セット
		Article article = new Article();
		article.setStatus("PUB");
		model.addAttribute("article", article);
		return "add-article";
	}

	@PostMapping("/add")
	public String addArticlePost(
			HttpSession session,
			@RequestParam("upfile") MultipartFile upfile,
			@Valid Article article,
			Errors errors,
			Model model,
			RedirectAttributes redirectAttributes) throws Exception {

		//投稿者＝ログインユーザー
		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");
		article.setUserId(loginStatus.getId());

		if (!upfile.isEmpty()) {
			String type = upfile.getContentType();
			if (!type.startsWith("image/")) {
				errors.rejectValue("upfile", "error.not_image_file");
			}
		}

		if (errors.hasErrors()) {
			return "add-article";
		}

		service.addArticle(article, upfile);
		redirectAttributes.addFlashAttribute("message", "投稿を追加しました。");
		return "redirect:/article/list";
	}

	@GetMapping("/edit/{id}")
	public String edit(
			HttpSession session,
			@PathVariable Integer id,
			Model model) throws Exception {
		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");
		model.addAttribute("article", service.getArticleById(id, loginStatus.getId()));
		return "edit-article";
	}

	@PostMapping("/edit/{id}")
	public String edit(
			@PathVariable Integer id,
			@Valid Article article,
			Errors errors,
			Model model,
			RedirectAttributes redirectAttributes) throws Exception {

		if (errors.hasErrors()) {
			return "edit-article";
		}

		service.editArticle(article);
		redirectAttributes.addFlashAttribute("message", "投稿を編集しました。");
		return "redirect:/article/list";
	}

	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable Integer id,
			RedirectAttributes redirectAttributes) throws Exception {
		service.deleteArticleById(id);
		redirectAttributes.addFlashAttribute("message", "投稿を削除しました。");
		return "redirect:/article/list";
	}

}
