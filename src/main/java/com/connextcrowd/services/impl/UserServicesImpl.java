package com.connextcrowd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connextcrowd.entity.UserProfile;
import com.connextcrowd.entity.Users;
import com.connextcrowd.repository.user.UserJpaRepository;
import com.connextcrowd.repository.user.UserProfileRepository;
import com.connextcrowd.repository.user.UserRepository;
import com.connextcrowd.services.UserService;
import com.connextcrowd.wrapper.RestResponseWrapper;


@Service
public class UserServicesImpl implements UserService{
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public UserJpaRepository userJpaRepository;
	@Autowired
	public UserProfileRepository userProfileRepository;
	
	@Override
	public RestResponseWrapper<Users> addUpdateUser(Users u) {
		Users user = userRepository.save(u);
		RestResponseWrapper<Users> restResponseWrapper  = new RestResponseWrapper<Users>();
		 restResponseWrapper.setEntity(user);
		 return restResponseWrapper;
	}

	@Override
	public void removeUser(Users u) {
		 userRepository.delete(u.getId());;
	}

	@Override
	public RestResponseWrapper<Users> userLogin(Users u) {
		Users user = userJpaRepository.userLogin(u.getUsername(), u.getPassword());
		RestResponseWrapper<Users> restResponseWrapper  = new RestResponseWrapper<Users>();
		restResponseWrapper.setEntity(user);
		return restResponseWrapper;
	}

	@Override
	public RestResponseWrapper<UserProfile> createUserProfile(UserProfile u) {
		UserProfile userprofile = userProfileRepository.save(u);
		RestResponseWrapper<UserProfile> restResponseWrapper  = new RestResponseWrapper<UserProfile>();
		restResponseWrapper.setEntity(userprofile);
		return restResponseWrapper;
	}

	@Override
	public RestResponseWrapper<UserProfile> getUserProfile(Long id) {
		UserProfile userprofile = userProfileRepository.findOne(id);
		RestResponseWrapper<UserProfile> restResponseWrapper  = new RestResponseWrapper<UserProfile>();
		restResponseWrapper.setEntity(userprofile);
		return restResponseWrapper;
	}

}
