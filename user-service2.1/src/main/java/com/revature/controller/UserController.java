package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entity.User;
import com.revature.service.UserService;

import springSecurity.UserPrincipal;
@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		
		this.userService=userService;
	}
	
	
	@GetMapping("test")
	public String hello() {
		
		return "hello";
	}
	
	@PostMapping(value="/login")
	public User login(@RequestBody User user) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal userPrince = (UserPrincipal)auth.getPrincipal();
		user.setFirstName(userPrince.getUsername());
		
		return userService.getUserByEmail(user);
	}

}
