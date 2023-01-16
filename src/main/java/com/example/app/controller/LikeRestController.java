package com.example.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.login.LoginStatus;
import com.example.app.service.LikeService;

@RestController
@RequestMapping("/like")
public class LikeRestController {

	@Autowired
	LikeService service;

	@GetMapping("/add")
	public long add(
			HttpSession session,
			@RequestParam Integer articleId) throws Exception {
		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");
		service.addLike(loginStatus.getId(), articleId);
		long likeCount = service.getTotalLikes(articleId);
		return likeCount;
	}

	@GetMapping("/delete")
	public long delete(
			HttpSession session,
			@RequestParam Integer articleId) throws Exception {
		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");
		service.deleteLike(loginStatus.getId(), articleId);
		long likeCount = service.getTotalLikes(articleId);
		return likeCount;
	}

}
