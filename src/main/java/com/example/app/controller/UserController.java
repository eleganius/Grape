package com.example.app.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.User;
import com.example.app.login.LoginStatus;
import com.example.app.service.ArticleService;
import com.example.app.service.UserService;
import com.example.app.validation.AddUserGroup;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final int NUM_PER_PAGE = 9;

	@Autowired
	UserService userService;

	@Autowired
	ArticleService articleService;

	@GetMapping("/show/{id}")
	public String show(
			@PathVariable Integer id,
			@RequestParam(name = "status", defaultValue = "PUB") String status,
			HttpSession session,
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			Model model) throws Exception {

		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");
		Integer loginUserId = loginStatus.getId();
		model.addAttribute("user", userService.getUserByIdWithFollowCount(loginUserId, id));

		model.addAttribute("currentPage", page);

		//公開投稿一覧とそのページネーションロジック
		if (status.equals("PRI")) {
			model.addAttribute("totalPages", articleService.getTotalPrivatePagesByUserId(NUM_PER_PAGE, id));
			model.addAttribute("articleList",
					articleService.getArticleListByPageAndUserIdAndPrivate(page, NUM_PER_PAGE, loginStatus.getId()));
		}
		//非公開投稿一覧とそのページネーションロジック
		else if (status.equals("LIKED")) {
			model.addAttribute("totalPages", articleService.getTotalLikedPagesByUserId(NUM_PER_PAGE, id));
			model.addAttribute("articleList",
					articleService.getArticleListByPageAndUserIdAndLiked(page, NUM_PER_PAGE, loginStatus.getId()));
		}
		//いいねした投稿一覧とそのページネーションロジック
		else {
			model.addAttribute("totalPages", articleService.getTotalPagesByUserId(NUM_PER_PAGE, id));
			model.addAttribute("articleList",
					articleService.getArticleListByPageAndShowUserId(page, NUM_PER_PAGE, loginStatus.getId(), id));
		}

		return "show-user";
	}

	@GetMapping("/add")
	public String addUserGet(Model model) {
		model.addAttribute("user", new User());
		return "add-user";
	}

	@PostMapping("/add")
	public String addUserPost(
			@RequestParam("upfile") MultipartFile upfile,
			@Validated(AddUserGroup.class) User user,
			Errors errors,
			Model model,
			RedirectAttributes redirectAttributes) throws Exception {

		errors = addEditValidCommon(upfile, user, errors);

		if (errors.hasErrors()) {
			return "add-user";
		}

		userService.addUser(user, upfile);
		redirectAttributes.addFlashAttribute("message", "登録しました。");
		return "redirect:/user/login";
	}

	@GetMapping("/edit/{id}")
	public String edit(
			@PathVariable Integer id,
			Model model) throws Exception {
		model.addAttribute("user", userService.getUserById(id));
		return "edit-user";
	}

	@PostMapping("/edit/{id}")
	public String edit(
			@RequestParam("upfile") MultipartFile upfile,
			@PathVariable Integer id,
			@Valid User user,
			Errors errors,
			Model model,
			RedirectAttributes redirectAttributes) throws Exception {

		errors = addEditValidCommon(upfile, user, errors);

		if (errors.hasErrors()) {
			user.setAvatar(userService.getUserById(id).getAvatar());
			return "edit-user";
		}

		userService.editUser(user, upfile);
		redirectAttributes.addFlashAttribute("message", "変更しました。");
		return "redirect:/user/show/{id}";
	}

	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable Integer id,
			RedirectAttributes redirectAttributes) throws Exception {
		userService.deleteUserById(id);
		redirectAttributes.addFlashAttribute("message", "退会しました。");
		return "redirect:/user/login";
	}

	//add&edit共通処理
	private Errors addEditValidCommon(MultipartFile upfile, User user, Errors errors) {

		if (!upfile.isEmpty()) {
			String type = upfile.getContentType();
			if (!type.startsWith("image/")) {
				errors.rejectValue("upfile", "error.not_image_file");
			}
		}

		if (!user.getEmail().equals(user.getEmailConf())) {
			errors.rejectValue("emailConf", "error.email.inequal");
		}

		return errors;
	}

}
