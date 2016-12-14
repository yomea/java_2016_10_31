package com.booway.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.booway.pojo.User;
import com.booway.service.UserService;

@Controller
public class UserController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE + ";charset=utf-8")
	public String queryUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "test.ftl";
	}

}
