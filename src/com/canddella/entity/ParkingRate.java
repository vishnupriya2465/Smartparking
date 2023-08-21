package com.canddella.entity;

public class ParkingRate {
	private String rateId;
	private FloorDetails floordetails;
	private double hourlyRate;
	public ParkingRate(String rateId, FloorDetails floordetails, double hourlyRate) {
		super();
		this.rateId = rateId;
		this.floordetails = floordetails;
		this.hourlyRate = hourlyRate;
	}
	public String getRateId() {
		return rateId;
	}
	public void setRateId(String rateId) {
		this.rateId = rateId;
	}
	public FloorDetails getFloordetails() {
		return floordetails;
	}
	public void setFloordetails(FloorDetails floordetails) {
		this.floordetails = floordetails;
	}
	public double getHourlyRate() {
		return hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	

}
