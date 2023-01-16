package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.Comment;
import com.example.app.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService service;

	@PostMapping("/add")
	public Comment addCommentPost(
			@RequestParam Integer userId,
			@RequestParam Integer articleId,
			@RequestParam String body) throws Exception {
		Comment comment = new Comment();
		comment.setUserId(userId);
		comment.setArticleId(articleId);
		comment.setBody(body);
		return comment;
	}
}
