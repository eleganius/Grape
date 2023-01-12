package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dao.ArticleDao;
import com.example.app.domain.Article;

@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleDao articleDao;

	@Override
	public List<Article> getArticleList() throws Exception {
		return articleDao.selectAll();
	}

	@Override
	public int getTotalPages(int numPerPage) throws Exception {
		double totalNum = (double) articleDao.count();
		return (int) Math.ceil(totalNum / numPerPage);
	}

	@Override
	public List<Article> getArticleListByPage(int page, int numPerPage) throws Exception {
		int offset = numPerPage * (page - 1);
		return articleDao.selectLimited(offset, numPerPage);
	}

}
