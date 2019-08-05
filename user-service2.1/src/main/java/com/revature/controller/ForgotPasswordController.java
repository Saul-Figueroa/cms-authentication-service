package com.revature.controller;

import javax.mail.MessagingException;

import com.revature.entity.User;
import com.revature.mail.JavaMailUtil;

public class ForgotPasswordController {
	
	public static void main(String[] args) throws MessagingException {
		
		User user = new User();
		user.setEmail("sauleff@gmail.com");
		
		JavaMailUtil.sendMail(user, "http:www.google.com");
		
	}
	

}
