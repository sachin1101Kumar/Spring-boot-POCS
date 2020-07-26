package com.registration.loginapp.bo;

import com.registration.loginapp.model.User;

public abstract class LoginBO {

	public abstract User RequestMapper(User user,UserBO bo);
	public abstract UserBO ResponseMapper(User user,UserBO bo);
	
}
