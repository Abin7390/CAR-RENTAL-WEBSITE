package com.carRental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carRental.entity.cars;
import com.carRental.repository.carsRepository;


	@Service
	public class carsService {
		
		
		@Autowired
	    private carsRepository carRepository;

	    public void save(cars c) {
	        carRepository.save(c);
	    }

	    public List<cars> getAllCars() {
	        return carRepository.findAll();
	    }

	   
	}