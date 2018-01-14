package com.connextcrowd.processors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.connextcrowd.entity.Company;
import com.connextcrowd.services.CompanyService;
import com.connextcrowd.wrapper.PCProcessor;
import com.connextcrowd.wrapper.RestResponseWrapper;


@Component
public class CompanyProcessor extends PCProcessor{
	@Autowired 
	private CompanyService companyServices;
	
	public RestResponseWrapper<Company> addCompany(Company company){
		return companyServices.addCompany(company);
	}
}
