package com.example.app.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public Comment addComment(Comment comment) throws Exception {
		service.addComment(comment);
		Comment newComment = service.getCommentById(comment.getId());

		//非同期コメント描画用：Date型をString型へ変換
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm");
		newComment.setCreatedAtSfd(sdf.format(newComment.getCreatedAt()));

		return newComment;
	}

	@GetMapping("/delete")
	public void deleteComment(
			@RequestParam Integer commentId) throws Exception {
		service.deleteCommentById(commentId);
	}
}
