package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.CommentDao;
import com.example.app.domain.Comment;

@Service
public class CommentSeviceImpl implements CommentService {

	@Autowired
	CommentDao dao;

	@Override
	public List<Comment> getCommentListByArticleId(Integer articleId) throws Exception {
		return dao.selectAllByArticleId(articleId);
	}

	@Override
	public void addComment(Comment comment) throws Exception {
		dao.insert(comment);

	}

}
