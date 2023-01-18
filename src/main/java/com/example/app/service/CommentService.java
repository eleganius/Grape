package com.example.app.service;

import com.example.app.domain.Comment;

public interface CommentService {

	Comment getCommentById(Integer id) throws Exception;

	long getTotalCommentsByArticleId(Integer articleId) throws Exception;

	void addComment(Comment comment) throws Exception;

	void deleteCommentById(Integer id) throws Exception;

}
