package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Article;

@Mapper
public interface ArticleDao {

	List<Article> selectAll() throws Exception;

}
