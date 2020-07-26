package com.registration.loginapp.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.registration.loginapp.bo.LoginBO;
import com.registration.loginapp.bo.UserBO;
import com.registration.loginapp.model.User;
import com.registration.loginapp.repository.UserRepository;

@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LoginBO loginBO;
	
	@Override
	public UserBO saveUser(UserBO bo) {
	
		User user=new User();
		if(bo!=null) {
			 user=loginBO.RequestMapper(user, bo);
       }
		if(user!=null) {
			user=userRepository.save(user);
			bo=loginBO.ResponseMapper(user, bo);
		}
		return bo;
	}

	@Override
	public List<UserBO> getAllUsers() {
		List<User> users=userRepository.findAll();
		List<UserBO> userBOs=new ArrayList<UserBO>();
	    
	   
	    for(User user:users) {
	    	try(UserBO userBO=new UserBO()) {
				UserBO userBoRes=loginBO.ResponseMapper(user, userBO);
				userBOs.add(userBoRes);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
	    
	   	System.out.println(userBOs);
		return userBOs;
	}

	@Override
	public UserBO deleteUser(UserBO bo) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
