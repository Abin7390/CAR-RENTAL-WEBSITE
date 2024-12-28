package com.carRental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carRental.entity.register;
import com.carRental.repository.registerRepository;

@Service
public class registerService {
	@Autowired
	public registerRepository bRepo;
	public void save(register r) {
	bRepo.save(r);
	}
	public List <register> getAllregister()
	{
		return bRepo.findAll();
	}
	

}
