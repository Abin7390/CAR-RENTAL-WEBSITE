package com.carRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carRental.entity.cars;


@Repository
public interface carsRepository extends JpaRepository<cars, Long> {

	cars findByCarsid(Long carsId);
}

