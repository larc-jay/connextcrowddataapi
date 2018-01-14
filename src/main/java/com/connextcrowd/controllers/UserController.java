package com.connextcrowd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.connextcrowd.entity.UserProfile;
import com.connextcrowd.entity.Users;
import com.connextcrowd.processors.UserProcessor;
import com.connextcrowd.util.ResponseEnums.StatusCode;
import com.connextcrowd.wrapper.RestResponseWrapper;
import com.connextcrowd.wrapper.ServiceResponse;
import com.connextcrowd.wrapper.ServiceResponse.ResStatus;


@RestController
@RequestMapping(UserController.API_BASE_URI)
public class UserController {

	private final Logger LOG = (Logger) LoggerFactory.getLogger(this.getClass());
	protected static final String API_BASE_URI = "jp/v1/user/";
	@Autowired 
	public UserProcessor userProcessor;



	@RequestMapping(value="/addUpdateUser", method = RequestMethod.POST)
	public ServiceResponse<RestResponseWrapper<Users>> addUpdateUser(@RequestBody  Users user){
		final ServiceResponse<RestResponseWrapper<Users>> response = new ServiceResponse<RestResponseWrapper<Users>>();
		try{
			RestResponseWrapper<Users> userList = userProcessor.addUpdateUser(user);
			response.setData(userList);
			response.setMessage("Request for users data success");
			response.setStatus(ResStatus.SUCCESS);
			response.setStatusCode(StatusCode.REQUEST_SUCCESS);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			response.setStatus(ResStatus.ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	@RequestMapping(value="/removeUser", method = RequestMethod.POST)
	public ServiceResponse<RestResponseWrapper<Users>> removeUser(@RequestBody  Users user){
		final ServiceResponse<RestResponseWrapper<Users>> response = new ServiceResponse<RestResponseWrapper<Users>>();
		try{
			userProcessor.removeUser(user);
			response.setMessage("Requested  users deleted");
			response.setStatus(ResStatus.SUCCESS);
			response.setStatusCode(StatusCode.REQUEST_SUCCESS);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			response.setStatus(ResStatus.ERROR);
			response.setMessage("user not found :"+e.getMessage());
		}
		return response;


	}
	@RequestMapping(value="/userLogin", method = RequestMethod.POST)
	public ServiceResponse<RestResponseWrapper<Users>> userLogin(@RequestBody  Users user){
		final ServiceResponse<RestResponseWrapper<Users>> response = new ServiceResponse<RestResponseWrapper<Users>>();
		try{
			RestResponseWrapper<Users> userList = userProcessor.userLogin(user);
			if(userList.getEntity()!=null && userList.getEntity().getId()>0){
				response.setData(userList);
				response.setMessage("Request for users login success");
				response.setStatus(ResStatus.SUCCESS);
				response.setStatusCode(StatusCode.REQUEST_SUCCESS);
			}else{
				response.setMessage("user not found :");
			}
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			response.setStatus(ResStatus.ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	@RequestMapping(value="/createUserProfile", method = RequestMethod.POST)
	public ServiceResponse<RestResponseWrapper<UserProfile>> createUserProfile(@RequestBody  UserProfile userProfile){
		final ServiceResponse<RestResponseWrapper<UserProfile>> response = new ServiceResponse<RestResponseWrapper<UserProfile>>();
		return response;
		
	}
	@RequestMapping(value="/getUserProfile", method = RequestMethod.POST)
	public ServiceResponse<RestResponseWrapper<UserProfile>> getUserProfile(@RequestBody  UserProfile userProfile){
		final ServiceResponse<RestResponseWrapper<UserProfile>> response = new ServiceResponse<RestResponseWrapper<UserProfile>>();
		try{
			RestResponseWrapper<UserProfile> profile = userProcessor.getUserProfile(userProfile.getId());
			if(profile.getEntity()!=null && profile.getEntity().getId()>0){
				response.setData(profile);
				response.setMessage("Request for user profile data");
				response.setStatus(ResStatus.SUCCESS);
				response.setStatusCode(StatusCode.REQUEST_SUCCESS);
			}else{
				response.setMessage("profile not found :");
			}
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			response.setStatus(ResStatus.ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
		
	}
}
