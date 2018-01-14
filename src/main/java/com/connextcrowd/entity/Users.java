package com.connextcrowd.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
      private Long id;
      private String username;
      private String firstname;
      private String password;
      private String lastname;
      private String email;
      private Type type = Type.IDENTIFIED;;
      private String origin;
      private String role;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Type getType() {
		return type;
	}
	public void setType(String type) {
		this.type = Type.valueOf(type);
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Origin getOrigin() {
		try {
			return Origin.valueOf(origin);
		} catch (Exception e) {
			Logger LOG = (Logger) LoggerFactory.getLogger(this.getClass());;
			LOG.warn("Origin  from database: " + origin + ", but no matching origin found, so returning 'OTHERS'");
			return Origin.OTHERS;
		}
	}
	public void setOrigin(Origin origin) {
		this.origin = origin.name();
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public enum Type {
		IDENTIFIED, UNIDENTIFIED
	}  
	public enum Origin {
		INTERNAL_ADMIN, EXTERNAL_ADMIN, INTERNAL , EXTERNAL , OTHERS 
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
