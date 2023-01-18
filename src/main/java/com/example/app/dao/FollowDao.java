package com.example.app.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowDao {

	long countFollowing(Integer showUserId) throws Exception;

	long countFollowee(Integer showUserId) throws Exception;

	void insert(Integer loginUserId, Integer showUserId) throws Exception;

	void delete(Integer loginUserId, Integer showUserId) throws Exception;

}
