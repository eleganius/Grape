package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.domain.Article;

@Service
public interface ArticleService {

	List<Article> getArticleListByPage(int page,
			int numPerPage, Integer loginStatusId) throws Exception;

	List<Article> getArticleListByPageAndShowUserId(int page,
			int numPerPage, Integer loginStatusId, Integer id) throws Exception;

	List<Article> getArticleListByPageAndUserIdAndPrivate(int page,
			int numPerPage, Integer loginStatusId) throws Exception;

	List<Article> getArticleListByPageAndUserIdAndLiked(int page,
			int numPerPage, Integer loginStatusId) throws Exception;

	int getTotalPages(int numPerPage) throws Exception;

	int getTotalPagesByUserId(int numPerPage, Integer id) throws Exception;

	int getTotalPrivatePagesByUserId(int numPerPage, Integer id) throws Exception;

	int getTotalLikedPagesByUserId(int numPerPage, Integer id) throws Exception;

	Article getArticleById(Integer id) throws Exception;

	void addArticle(Article article, MultipartFile upfile) throws Exception;

	void editArticle(Article article) throws Exception;

	void deleteArticleById(Integer id) throws Exception;

}
