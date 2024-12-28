package com.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carRental.entity.adminlogin;



@Repository
public interface adminloginRepository extends JpaRepository<adminlogin, Long> {
    adminlogin findByUsername(String username); 
    adminlogin findByUsernameAndPassword(String username, String password); 

}


