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
	UserDao dao;

	@Override
	public User getUserByEmail(String email) throws Exception {
		return dao.selectUserByEmail(email);
	}

	@Override
	public User getUserById(Integer id) throws Exception {
		return dao.selectUserById(id);
	}

	@Override
	public User getUserByIdsWithFollowCount(Integer loginUserId, Integer showUserId) throws Exception {
		return dao.selectUserByIdsWithFollowCount(loginUserId, showUserId);
	}

	@Override
	public void addUser(User user, MultipartFile upfile) throws Exception {
		dao.insert(addEditCommon(user, upfile));
	}

	@Override
	public void editUser(User user, MultipartFile upfile) throws Exception {
		dao.update(addEditCommon(user, upfile));
	}

	@Override
	public void deleteUserById(Integer id) throws Exception {
		dao.setDeleteById(id);
	}

	//add&edit共通処理
	private User addEditCommon(User user, MultipartFile upfile) throws Exception {
		if (!upfile.isEmpty()) {
			//upfileに値があったら
			String avatar = upfile.getOriginalFilename();
			user.setAvatar(avatar);
			Path path = Paths.get("uploads/" + avatar);
			upfile.transferTo(path);
		} else if (dao.selectUserById(user.getId()) == null) {
			//新規ユーザーはDB登録なしのためnull
			user.setAvatar("user_icon.png"); //デフォルトユーザーアイコン
		} else {
			//編集ユーザーはDB登録ありのため維持
			user.setAvatar(dao.selectUserById(user.getId()).getAvatar());
		}

		user.setLoginPass(BCrypt.hashpw(user.getLoginPass(), BCrypt.gensalt()));
		return user;
	}

}
