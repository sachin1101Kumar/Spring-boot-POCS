package com.registration.loginapp.bo.impl;

import com.registration.loginapp.bo.LoginBO;
import com.registration.loginapp.bo.UserBO;
import com.registration.loginapp.model.User;
import com.registration.loginapp.security.PasswordHashing;

public class LoginBOImpl extends LoginBO {

	@Override
	public User RequestMapper(User user, UserBO bo) {
		PasswordHashing hashing=new PasswordHashing();
		if(bo!=null) {
			user.setNameString(bo.getName());
			user.setAge(bo.getAge());
			user.setPassword(hashing.getEncryptedPassword(bo.getPassword()));
		}
		return user;
	}

	@Override
	public UserBO ResponseMapper(User requestUser, UserBO bo) {
		if(bo==null) {
			bo=new UserBO();
		}
		if(requestUser!=null) {
            bo.setId(requestUser.getUserid());
			bo.setName(requestUser.getNameString());
			bo.setAge(requestUser.getAge());
			bo.setPassword(requestUser.getPassword());
		}
		return bo;
	}

	
}
