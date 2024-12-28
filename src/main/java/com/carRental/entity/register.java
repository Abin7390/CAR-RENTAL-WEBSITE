package com.carRental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class register {

	@Id
	private String username;
	private String fullname;
	private String email;
	private String password;
	private String license;
	private String address;
	private String phone;
	private String role;
	
	public register(String username, String fullname, String email, String password, String license, String address,
			String phone, String role) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.license = license;
		this.address = address;
		this.phone = phone;
		this.phone = role;
	}
	public register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
