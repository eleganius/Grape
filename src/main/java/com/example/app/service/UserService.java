package com.example.app.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.domain.User;

@Service
public interface UserService {

	User getUserByEmail(String email) throws Exception;

	User getUserById(Integer id) throws Exception;

	User getUserByIdWithFollowCount(Integer loginUserId, Integer showUserId) throws Exception;

	void addUser(User user, MultipartFile upfile) throws Exception;

	void editUser(User user, MultipartFile upfile) throws Exception;

	void deleteUserById(Integer id) throws Exception;

}
