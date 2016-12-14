package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController() {
		
	}
	
	@RequestMapping("/register")
	public String save(@ModelAttribute("user") User user) {
		int row = userService.save(user);
		if(row > 0) {
			return "success";
			
		}
		return "register";
	}
	
	@RequestMapping("/index")
	public String register() {
		
		return "register";
	}
	
	@RequestMapping("/list")
	public String list_user(Model model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "userList";
	}
	
}
