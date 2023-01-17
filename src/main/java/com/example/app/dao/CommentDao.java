package com.example.app.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Comment;

@Mapper
public interface CommentDao {

	Comment selectCommentById(Integer id) throws Exception;

	void insert(Comment commnent) throws Exception;

}
