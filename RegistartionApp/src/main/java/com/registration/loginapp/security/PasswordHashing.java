package com.registration.loginapp.security;

import com.lambdaworks.crypto.SCryptUtil;

public class PasswordHashing {

	 public String getEncryptedPassword (String password) {
	        //String originalPassword = "password";
	        String generatedSecuredPasswordHash = SCryptUtil.scrypt(password, 16, 16, 16);
	        System.out.println("Encrypted Password is "+generatedSecuredPasswordHash);
	         
			/*
			 * boolean matched = SCryptUtil.check("password", generatedSecuredPasswordHash);
			 * System.out.println(matched);
			 * 
			 * matched = SCryptUtil.check("passwordno", generatedSecuredPasswordHash);
			 * System.out.println(matched);
			 */
	        return generatedSecuredPasswordHash;
	    }
	}
	 

