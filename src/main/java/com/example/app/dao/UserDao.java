package com.example.app.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface UserDao {

	//ログイン用
	User selectUserByEmail(String email) throws Exception;

	//ユーザー編集用
	User selectById(Integer id) throws Exception;

	//show-user.html用
	User selectByIdWithFollowCount(Integer loginUserId, Integer showUserId) throws Exception;

	void insert(User user) throws Exception;

	void update(User user) throws Exception;

	void setDeleteById(Integer id) throws Exception;

}
