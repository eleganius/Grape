package com.example.app.service;

import java.util.List;

import com.example.app.domain.Comment;

public interface CommentService {

	List<Comment> getCommentListByArticleId(Integer articleId) throws Exception;

	void addComment(Comment comment) throws Exception;

}
