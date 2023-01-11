package com.example.app.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Article;
import com.example.app.service.ArticleService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	ArticleDao articleDao;

	@Override
	public List<Article> getArticleList(Integer id) throws Exception {
		return articleDao.selectAll(id);
	}

}
