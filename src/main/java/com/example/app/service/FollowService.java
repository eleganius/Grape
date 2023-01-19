package com.example.app.service;

import java.util.List;

import com.example.app.domain.Follow;

public interface FollowService {

	long getTotalFollowing(Integer showUserId) throws Exception;

	List<Follow> getFollowingUser(Integer showUserId) throws Exception;

	long getTotalFollowee(Integer showUserId) throws Exception;

	List<Follow> getFolloweeUser(Integer showUserId) throws Exception;

	void addFollow(Integer loginUserId, Integer showUserId) throws Exception;

	void deleteFollow(Integer loginUserId, Integer showUserId) throws Exception;

}
