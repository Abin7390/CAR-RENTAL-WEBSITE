package com.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carRental.entity.carbooking;

@Repository
public interface carbookingRepository extends JpaRepository<carbooking, String>{

}
