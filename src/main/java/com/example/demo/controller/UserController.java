package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String showSignupPage() {
		return "index";
	}
	
	@PostMapping("/register")
	public String registerUser(User user) {
		boolean exist = userService.register(user);
		if (exist) {
		System.out.println("Registration successful");
		return "login";
		}
		System.out.println("User exist");
		return "login";
	}
	
	@GetMapping("/login")
	public String displayLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam String email, @RequestParam String password) {
		boolean status = userService.loginAndGeneratedOtp(email, password);
		if (status == true) {
			return "otp";
		}else {
			return "loginfail";
		}
	}
	
	@PostMapping("/verifyOTP")
	public String verifyotp(@RequestParam String otp) {
		boolean status = userService.verifyotp(otp);
		if (status == true) {
			return "homepage";
		} else {
			return "loginfail";
		}
	}

}
