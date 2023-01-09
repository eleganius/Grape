package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/grape")
public class LikeController {

	@GetMapping("/addLike")
	public String addFollowGet() {
		//DB追加処理
		//DB接続後likeCountApiへフォワード(DBよりいいね数取得)
		return "redirect:/grape/user/0";
	}

	@GetMapping("/deleteLike")
	public String deleteFollowGet() {
		//DB削除処理
		//DB接続後likeCountApiへフォワード(DBよりいいね数取得)
		return "redirect:/grape/user/0";
	}

}
