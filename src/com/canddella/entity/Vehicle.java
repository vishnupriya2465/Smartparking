package com.canddella.entity;

public class Vehicle {
private int vehicleId;
private String vehicleType;
private  Customer customer;
public Vehicle(int vehicleId, String vehicleType, Customer customer) {
	super();
	this.vehicleId = vehicleId;
	this.vehicleType = vehicleType;
	this.customer = customer;
}
public Vehicle() {
	// TODO Auto-generated constructor stub
}
public int getVehicleId() {
	return vehicleId;
}
public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}
public String getVehicleType() {
	return vehicleType;
}
public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

}
