package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.dao.FollowDao;
import com.example.app.domain.Follow;

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
	public List<Follow> getFollowingUser(Integer showUserId) throws Exception {
		return dao.selectFollowing(showUserId);
	}

	@Override
	public long getTotalFollowee(Integer showUserId) throws Exception {
		return dao.countFollowee(showUserId);
	}

	@Override
	public List<Follow> getFolloweeUser(Integer showUserId) throws Exception {
		return dao.selectFollowee(showUserId);
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
