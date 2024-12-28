package com.carRental.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class carbooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;
	private String username;
	private String carnumber;
	private Date fromDate;
	private Date toDate;
	private String amount;
	private Long carsid;
	private String status;
	private String priceperday;
	public carbooking(int bookingid, String username, String carnumber, Date fromDate, Date toDate, String amount, Long carsid, String status, String priceperday) {
		super();
		this.bookingid = bookingid;
		this.username = username;
		this.carnumber = carnumber;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.amount = amount;
		this.status = status;
		this.status = priceperday;
	}
	public carbooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookingid() {
		return bookingid;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCarnumber() {
		return carnumber;
	}
	public void setCarnumber(String carnumber) {
		this.carnumber = carnumber;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public Long getCarsid() {
		return carsid;
	}
	public void setCarsid(Long carsid) {
		this.carsid = carsid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	 public String getPriceperday() {
	        return priceperday;
	    }
	    public void setPriceperday(String priceperday) {
	        this.priceperday = priceperday;
	    }
	
}