package com.example.app.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeDao {

	long countLike(Integer articleId) throws Exception;

	void insert(Integer loginStatusId, Integer articleId) throws Exception;

	void delete(Integer loginStatusId, Integer articleId) throws Exception;

}
