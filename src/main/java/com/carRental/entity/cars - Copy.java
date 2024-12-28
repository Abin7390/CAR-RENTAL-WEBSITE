package com.carRental.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class cars {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long carsid;
	 private String carimage;
	 private String carnumber;
	 private String carmodel;
	 private String priceperday;
	 private String status;
	public cars(Long carsid, String carimage, String carnumber, String carmodel, String priceperday, String status) {
		super();
		this.carsid = carsid;
		this.carimage = carimage;
		this.carnumber = carnumber;
		this.carmodel = carmodel;
		this.priceperday = priceperday;
		this.status = status;
	}
	public cars() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getCarsid() {
		return carsid;
	}
	public void setCarsid(Long carsid) {
		this.carsid = carsid;
	}
	public String getCarimage() {
		return carimage;
	}
	public void setCarimage(String carimage) {
		this.carimage = carimage;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public String getCarmodel() {
		return carmodel;
	}
	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public String getPriceperday() {
		return priceperday;
	}
	public void setPriceperday(String priceperday) {
		this.priceperday = priceperday;
	}
	 public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }
	 
	 

	
	


}
