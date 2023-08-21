package com.canddella.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
	private String reservationId;
	private Customer customer;
	private Floor_Slot floor_slot;
	private LocalDate reservationDate;
	private LocalTime reservationTime;
	private LocalTime startTime;
	private LocalTime endTime;
	private String status;
	private Reservation reservation;
	public Reservation(String reservationId, Customer customer, Floor_Slot floor_slot, LocalDate reservationDate,
			LocalTime reservationTime, LocalTime startTime, LocalTime endTime, String status) {
		super();
		this.reservationId = reservationId;
		this.customer = customer;
		this.floor_slot = floor_slot;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}
	public Reservation() {

	}

	public String getReservationId() {
		return reservationId;
	}
	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Floor_Slot getFloor_slot() {
		return floor_slot;
	}
	public void setFloor_slot(Floor_Slot floor_slot) {
		this.floor_slot = floor_slot;
	}
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	public LocalTime getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
   
	
}
