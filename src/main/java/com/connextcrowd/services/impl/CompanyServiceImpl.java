package com.connextcrowd.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.connextcrowd.entity.Company;
import com.connextcrowd.repository.company.CompanyRepository;
import com.connextcrowd.services.CompanyService;
import com.connextcrowd.wrapper.RestResponseWrapper;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public RestResponseWrapper<Company> addCompany(Company company) {
		Company com = companyRepository.save(company);
		RestResponseWrapper<Company> restResponseWrapper  = new RestResponseWrapper<Company>();
		restResponseWrapper.setEntity(com);
		return restResponseWrapper;
	}

}
