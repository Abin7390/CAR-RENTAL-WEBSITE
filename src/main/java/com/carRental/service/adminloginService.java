package com.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carRental.entity.adminlogin;
import com.carRental.repository.adminloginRepository;

@Service
public class adminloginService {

	@Autowired 
	adminloginRepository adminrepo;
	
	  public adminlogin getRoleByUsername(String username) {
	        return adminrepo.findByUsername(username);
	  }
	        public adminlogin findByUsernameAndPassword(String username, String password)
	        {
	        	return adminrepo.findByUsernameAndPassword( username,  password);
	    }
}
