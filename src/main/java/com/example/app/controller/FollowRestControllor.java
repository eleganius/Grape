package com.example.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.Follow;
import com.example.app.login.LoginStatus;
import com.example.app.service.FollowService;

@RestController
@RequestMapping("/follow")
public class FollowRestControllor {

	@Autowired
	FollowService service;

	@GetMapping("/following")
	public List<Follow> showFollowing(
			@RequestParam Integer userId) throws Exception {
		List<Follow> followingList = service.getFollowingUser(userId);
		return followingList;
	}

	@GetMapping("/followee")
	public List<Follow> showFollowee(
			@RequestParam Integer userId) throws Exception {
		List<Follow> followeeList = service.getFolloweeUser(userId);
		System.out.println(followeeList);
		return followeeList;
	}

	@GetMapping("/add")
	public long add(
			HttpSession session,
			@RequestParam Integer showUserId) throws Exception {
		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");
		service.addFollow(loginStatus.getId(), showUserId);
		long followeeCount = service.getTotalFollowee(showUserId);
		return followeeCount;
	}

	@GetMapping("/delete")
	public long delete(
			HttpSession session,
			@RequestParam Integer showUserId) throws Exception {
		LoginStatus loginStatus = (LoginStatus) session.getAttribute("loginStatus");
		service.deleteFollow(loginStatus.getId(), showUserId);
		long followeeCount = service.getTotalFollowee(showUserId);
		return followeeCount;
	}

}
