package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Article;

@Service
public interface ArticleService {

	public List<Article> getArticleList(Integer id) throws Exception;

}
