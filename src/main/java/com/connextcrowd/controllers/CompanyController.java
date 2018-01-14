package com.connextcrowd.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.connextcrowd.entity.Company;
import com.connextcrowd.processors.CompanyProcessor;
import com.connextcrowd.util.ResponseEnums.StatusCode;
import com.connextcrowd.wrapper.RestResponseWrapper;
import com.connextcrowd.wrapper.ServiceResponse;
import com.connextcrowd.wrapper.ServiceResponse.ResStatus;


@RestController
@RequestMapping(CompanyController.API_BASE_URI)
public class CompanyController {
	private final Logger LOG = (Logger) LoggerFactory.getLogger(this.getClass());
	protected static final String API_BASE_URI = "jp/v1/company/";
	@Autowired 
	public CompanyProcessor companyProcessor;
	
	@RequestMapping(value="/addCompany", method = RequestMethod.POST)
	public ServiceResponse<RestResponseWrapper<Company>> addCompany(@RequestBody  Company company){
		final ServiceResponse<RestResponseWrapper<Company>> response = new ServiceResponse<RestResponseWrapper<Company>>();
		try{
			RestResponseWrapper<Company> userList = companyProcessor.addCompany(company);
			response.setData(userList);
			response.setMessage("Company added sucdesfully");
			response.setStatus(ResStatus.SUCCESS);
			response.setStatusCode(StatusCode.REQUEST_SUCCESS);
		}catch(Exception e){
			LOG.error(e.getMessage(),e);
			response.setStatus(ResStatus.ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}
}
