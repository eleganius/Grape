package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Comment;

@Mapper
public interface CommentDao {

	List<Comment> selectAllByArticleId(Integer articleId) throws Exception;

	void insert(Comment commnent) throws Exception;

}
