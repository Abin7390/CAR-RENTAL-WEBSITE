package com.carRental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carRental.entity.login;
import com.carRental.repository.loginRepository;

@Service
public class loginService {
    
    @Autowired
    private loginRepository repo;
  
  public login login(String username, String password) {
      login user = repo.findByUsernameAndPassword(username, password);
      return user;
  }
    

}