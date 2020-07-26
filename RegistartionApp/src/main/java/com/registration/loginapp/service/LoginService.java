package com.registration.loginapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.registration.loginapp.bo.UserBO;

@Service
public interface LoginService {

	public UserBO saveUser(UserBO bo);
	public List<UserBO> getAllUsers();
	public UserBO deleteUser(UserBO bo);
	
}
