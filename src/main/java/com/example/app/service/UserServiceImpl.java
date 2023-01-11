package com.example.app.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.dao.UserDao;
import com.example.app.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;

	@Override
	public boolean isCollectEmailAndLoginPass(String email, String loginPass) throws Exception {

		User loginUser = dao.selectUserByEmail(email);

		if (loginUser == null) {
			return false;
		}

		if (!BCrypt.checkpw(loginPass, loginUser.getLoginPass())) {
			return false;
		}

		return true;
	}

	@Override
	public User getUserByEmail(String email) throws Exception {
		return dao.selectUserByEmail(email);
	}

}
