package com.example.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Follow;

@Mapper
public interface FollowDao {

	long countFollowing(Integer showUserId) throws Exception;

	List<Follow> selectFollowing(Integer showUserId) throws Exception;

	long countFollowee(Integer showUserId) throws Exception;

	List<Follow> selectFollowee(Integer showUserId) throws Exception;

	void insert(Integer loginUserId, Integer showUserId) throws Exception;

	void delete(Integer loginUserId, Integer showUserId) throws Exception;

}
