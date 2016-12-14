package com.application.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.entity.User;
import com.application.mapper.UserMapper;
/**
 * 
 * @author may
 *
 */

@RestController
@RequestMapping({"/home"})
public class UserController {
@Autowired
UserMapper userMapper;
@RequestMapping(value = "/user")
@ResponseBody
public String user(){
User user = userMapper.findUserByName("youth");
return user.getUsername()+"-----"+user.getAge();
}
}