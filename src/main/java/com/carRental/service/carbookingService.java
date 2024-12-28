package com.carRental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carRental.entity.carbooking;
import com.carRental.entity.cars;
import com.carRental.repository.carbookingRepository;
import com.carRental.repository.carsRepository;

@Service
public class carbookingService {
	
	@Autowired
	public carbookingRepository cbRepo;
	
	@Autowired
	public carsRepository carRepository;
	
	
	public void bookCarAndUpdateStatus(carbooking form) {
        cars car = carRepository.findByCarsid(form.getCarsid());
        if (car != null) {
            car.setStatus(form.getStatus());
            carRepository.save(car); // Update car status
        }

        // Save the form data to the 'carbookings' table
        cbRepo.save(form); // Save other fields in carbooking

        // Or create a dedicated method in carbookingRepository to save the booking
        // cbRepo.saveBooking(form);
    }
	 public List<carbooking> getAllcarbookings() {
	        return cbRepo.findAll();
	    }

}
