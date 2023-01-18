package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.CommentDao;
import com.example.app.domain.Comment;

@Service
public class CommentSeviceImpl implements CommentService {

	@Autowired
	CommentDao dao;

	@Override
	public Comment getCommentById(Integer id) throws Exception {
		return dao.selectCommentById(id);
	}

	@Override
	public long getTotalCommentsByArticleId(Integer articleId) throws Exception {
		return dao.countCommentByArticleId(articleId);
	}

	@Override
	public void addComment(Comment comment) throws Exception {
		dao.insert(comment);
	}

	@Override
	public void deleteCommentById(Integer id) throws Exception {
		dao.deleteById(id);
	}

}
