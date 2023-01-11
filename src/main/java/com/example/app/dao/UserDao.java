package com.example.app.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface UserDao {

	User selectUserByEmail(String email) throws Exception;

}
