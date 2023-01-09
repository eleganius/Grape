package com.example.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Follow;
import com.example.app.domain.User;

@Service
public class UserService {

	private List<User> userList;

	public UserService() {
		userList = new ArrayList<>();

		userList.add(new User(1, "taro.webp", "太郎",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit labore impedit minima tenetur reiciendis laudantium tempore cupiditate doloribus aperiam maxime et ducimus eligendi dolorem vel illum molestiae doloremque. Provident ullam.",
				new Follow(100, 100)));
		userList.add(new User(2, "jiro.jpg", "次郎",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit labore impedit minima tenetur reiciendis laudantium tempore cupiditate doloribus aperiam maxime et ducimus eligendi dolorem vel illum molestiae doloremque. Provident ullam.",
				new Follow(200, 200)));
		userList.add(new User(3, "haruko.jpg", "春子",
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit labore impedit minima tenetur reiciendis laudantium tempore cupiditate doloribus aperiam maxime et ducimus eligendi dolorem vel illum molestiae doloremque. Provident ullam.",
				new Follow(300, 300)));
	}

	public User getUserById(int id) {
		return userList.get(id);
	}

}
