package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.User;

@Service
public interface UserService {

	boolean isCollectEmailAndLoginPass(String email, String loginPass) throws Exception;

	User getUserByEmail(String email) throws Exception;

}
