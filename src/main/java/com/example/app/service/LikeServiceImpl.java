package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dao.LikeDao;

@Service
@Transactional
public class LikeServiceImpl implements LikeService {

	@Autowired
	LikeDao dao;

	@Override
	public long getTotalLikes(Integer articleId) throws Exception {
		return dao.countLike(articleId);
	}

	@Override
	public void addLike(Integer loginStatusId, Integer articleId) throws Exception {
		dao.insert(loginStatusId, articleId);
	}

	@Override
	public void deleteLike(Integer loginStatusId, Integer articleId) throws Exception {
		dao.delete(loginStatusId, articleId);
	}

}
