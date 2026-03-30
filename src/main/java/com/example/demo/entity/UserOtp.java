package com.example.demo.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class UserOtp {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int otpId;
	@Column
	String otp;
	@Column
	int userId;
	
	
	public UserOtp() {
		super();
	}


	public UserOtp(int otpId, String otp, int userId) {
		super();
		this.otpId = otpId;
		this.otp = otp;
		this.userId = userId;
	}


	public int getOtpId() {
		return otpId;
	}


	public void setOtpId(int otpId) {
		this.otpId = otpId;
	}


	public String getOtp() {
		return otp;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
