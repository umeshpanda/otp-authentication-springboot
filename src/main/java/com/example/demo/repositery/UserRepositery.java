package com.example.demo.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;

public interface UserRepositery extends JpaRepository<User, Integer>{

	User findByEmail(String email);
}
