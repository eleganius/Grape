package com.example.app.service;

public interface LikeService {

	long getTotalLikes(Integer articleId) throws Exception;

	void addLike(Integer loginStatusId, Integer articleId) throws Exception;

	void deleteLike(Integer loginStatusId, Integer articleId) throws Exception;

}
