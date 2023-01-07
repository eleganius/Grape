package com.example.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Article;
import com.example.app.domain.User;

@Service
public class ArticleService {

	private List<Article> articleList;

	public ArticleService() {
		articleList = new ArrayList<>();
		articleList.add(new Article(1, 1, "wine1.jpg", "おはよう", getDate("2023-01-09 17:55"),
				new User(1, "taro.webp", "太郎")));
		articleList.add(new Article(2, 2, "wine2.jpg", "こんにちは", getDate("2023-01-08 16:55"),
				new User(2, "jiro.jpg", "次郎")));
		articleList.add(new Article(3, 3, "wine3.jpg", "こんばんは", getDate("2023-01-07 15:55"),
				new User(3, "haruko.jpg", "春子")));
	}

	public List<Article> getArticleList() {
		return articleList;
	}

	public Article getArticleById(int id) {
		return articleList.get(id);
	}

	private Date getDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return new Date();
		}
	}

}
