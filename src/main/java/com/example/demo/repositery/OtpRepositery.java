package com.example.demo.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserOtp;

public interface OtpRepositery extends JpaRepository<UserOtp, Integer>{

	UserOtp findByOtp(String otp);
}
