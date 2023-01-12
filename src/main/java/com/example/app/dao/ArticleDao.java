package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.Article;

@Mapper
public interface ArticleDao {

	List<Article> selectAll() throws Exception;

	Long count() throws Exception;

	List<Article> selectLimited(@Param("offset") int offset,
			@Param("num") int num) throws Exception;

}
