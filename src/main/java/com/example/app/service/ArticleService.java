package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Article;

@Service
public interface ArticleService {

	public List<Article> getArticleList() throws Exception;

	int getTotalPages(int numPerPage) throws Exception;

	List<Article> getArticleListByPage(int page, int numPerPage) throws Exception;

}
