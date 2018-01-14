package com.connextcrowd.services;

import org.springframework.stereotype.Service;

import com.connextcrowd.entity.Company;
import com.connextcrowd.wrapper.PCService;
import com.connextcrowd.wrapper.RestResponseWrapper;

@Service
public interface CompanyService extends PCService {
	public RestResponseWrapper<Company> addCompany(Company company);
}
