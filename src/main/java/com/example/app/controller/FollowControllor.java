package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grape")
public class FollowControllor {

	@GetMapping("/addFollow")
	public String addFollowGet() {
		//DB追加処理
		//DB接続後followerCountApiへフォワード(DBよりフォロワー数取得)
		return "redirect:/grape/user/0";
	}

	@GetMapping("/deleteFollow")
	public String deleteFollowGet() {
		//DB削除処理
		//DB接続後followerCountApiへフォワード(DBよりフォロワー数取得)
		return "redirect:/grape/user/0";
	}

}
