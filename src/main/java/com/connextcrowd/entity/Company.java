package com.connextcrowd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "company")
@Entity(name="company")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "contact_person")
	private String contactPerson;
	@Column(name = "cp_designation")
	private String designation;
	@Column(name = "cp_email")
	private String email;
	@Column(name = "cp_contact")
	private String contact;
	@Column(name = "signup_date")
	private String signupDate;
	@Column(name = "valid_from")
	private String validFrom;
	@Column(name = "valid_upto")
	private String validUpto;
	@Column(name = "business_dev_exe_name")
	private String businessDevExecutiveName;
	@Column(name = "address")
	private String address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(String signupDate) {
		this.signupDate = signupDate;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidUpto() {
		return validUpto;
	}
	public void setValidUpto(String validUpto) {
		this.validUpto = validUpto;
	}
	public String getBusinessDevExecutiveName() {
		return businessDevExecutiveName;
	}
	public void setBusinessDevExecutiveName(String businessDevExecutiveName) {
		this.businessDevExecutiveName = businessDevExecutiveName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
