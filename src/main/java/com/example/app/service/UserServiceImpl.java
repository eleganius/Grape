package com.example.app.service;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.dao.UserDao;
import com.example.app.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public User getUserByEmail(String email) throws Exception {
		return userDao.selectUserByEmail(email);
	}

	@Override
	public User getUserById(Integer id) throws Exception {
		return userDao.selectById(id);
	}

	@Override
	public void addUser(User user, MultipartFile upfile) throws Exception {
		userDao.insert(addEditCommon(user, upfile));

	}

	@Override
	public void editUser(User user, MultipartFile upfile) throws Exception {
		userDao.update(addEditCommon(user, upfile));
	}

	@Override
	public void deleteUserById(Integer id) throws Exception {
		userDao.setDeleteById(id);
	}

	//add&edit共通処理
	private User addEditCommon(User user, MultipartFile upfile) throws Exception {

		if (!upfile.isEmpty()) {
			String avatar = upfile.getOriginalFilename();
			user.setAvatar(avatar);
			Path path = Paths.get("uploads/" + avatar);
			upfile.transferTo(path);
		} else {
			//デフォルトユーザーアイコン
			user.setAvatar("user_icon.png");
		}

		user.setLoginPass(BCrypt.hashpw(user.getLoginPass(), BCrypt.gensalt()));
		return user;
	}

}
