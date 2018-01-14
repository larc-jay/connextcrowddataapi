package com.connextcrowd.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.connextcrowd.entity.UserProfile;
import com.connextcrowd.entity.Users;
import com.connextcrowd.services.UserService;
import com.connextcrowd.util.UserUtil;
import com.connextcrowd.wrapper.PCProcessor;
import com.connextcrowd.wrapper.RestResponseWrapper;



@Component
public class UserProcessor extends PCProcessor{
	@Autowired 
	private UserService userServices;
	public RestResponseWrapper<Users>  addUpdateUser(Users u) throws Exception {
		 u.setPassword(UserUtil.encodePwd(u.getPassword()));
		 return userServices.addUpdateUser(u);
	}
	public void  removeUser(Users u) throws Exception {
		  userServices.removeUser(u);
	}
	public RestResponseWrapper<Users>  userLogin(Users u) throws Exception {
		 u.setPassword(UserUtil.encodePwd(u.getPassword()));
		return userServices.userLogin(u);
	}
	public RestResponseWrapper<UserProfile>  createUserProfile(UserProfile u) throws Exception {
		return userServices.createUserProfile(u);
	}
	public RestResponseWrapper<UserProfile> getUserProfile(Long id) {
		return userServices.getUserProfile(id);
	}
}
