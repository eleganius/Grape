package com.example.app.service;

import com.example.app.domain.Comment;

public interface CommentService {

	Comment getCommentById(Integer id) throws Exception;

	void addComment(Comment comment) throws Exception;

}
