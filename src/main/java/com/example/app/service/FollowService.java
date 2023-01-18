package com.example.app.service;

public interface FollowService {

	long getTotalFollowing(Integer showUserId) throws Exception;

	long getTotalFollowee(Integer showUserId) throws Exception;

	void addFollow(Integer loginUserId, Integer showUserId) throws Exception;

	void deleteFollow(Integer loginUserId, Integer showUserId) throws Exception;

}
