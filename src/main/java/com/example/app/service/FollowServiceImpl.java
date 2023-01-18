package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dao.FollowDao;

@Service
@Transactional
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowDao dao;

	@Override
	public long getTotalFollowing(Integer showUserId) throws Exception {
		return dao.countFollowing(showUserId);
	}

	@Override
	public long getTotalFollowee(Integer showUserId) throws Exception {
		return dao.countFollowee(showUserId);
	}

	@Override
	public void addFollow(Integer loginUserId, Integer showUserId) throws Exception {
		dao.insert(loginUserId, showUserId);
	}

	@Override
	public void deleteFollow(Integer loginUserId, Integer showUserId) throws Exception {
		dao.delete(loginUserId, showUserId);
	}

}
