package com.connextcrowd.services;

import org.springframework.stereotype.Service;

import com.connextcrowd.entity.UserProfile;
import com.connextcrowd.entity.Users;
import com.connextcrowd.wrapper.PCService;
import com.connextcrowd.wrapper.RestResponseWrapper;

@Service
public interface UserService extends PCService{

	public RestResponseWrapper<Users> addUpdateUser(Users u);
	public void removeUser(Users u);
	public RestResponseWrapper<Users> userLogin(Users u);
	public RestResponseWrapper<UserProfile> createUserProfile(UserProfile u);
	public RestResponseWrapper<UserProfile> getUserProfile(Long id);
}
