package com.example.demo.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.entity.UserOtp;
import com.example.demo.repositery.OtpRepositery;
import com.example.demo.repositery.UserRepositery;

@Service
public class UserService {

	@Autowired
	UserRepositery userRepo;
	@Autowired
	OtpRepositery otpRepo;
	@Autowired
	JavaMailSender mailSender;
	
	
	public boolean register(User user) {
		 User existingUser = userRepo.findByEmail(user.getEmail());
		 if(existingUser != null) {
			 return false;
		 }
		userRepo.save(user);
		return true;
	}
	
	public boolean loginAndGeneratedOtp(String email, String password) {
		 
		User user = userRepo.findByEmail(email);
		if (user == null) {
			return false;
		}
		
		if (!user.getPassword().equals(password)) {
			return false;
		}
		
		int numotp = new Random().nextInt(100000, 1000000);
		String otp = String.valueOf(numotp);
		
		UserOtp userOtp = new UserOtp();
		userOtp.setOtp(otp);
		userOtp.setUserId(user.getId());
		otpRepo.save(userOtp);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmail());
		message.setSubject("This is the otp for login");
		message.setText("hey " + user.getName() + " this is the otp " + otp);
		mailSender.send(message);
		
		return true;
	}
	
	public boolean verifyotp(String otp) {
		UserOtp userOtp = otpRepo.findByOtp(otp);
		if (userOtp == null) {
			return false;
		} else {
			return true;
		}
	}
}
