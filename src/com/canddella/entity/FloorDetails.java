package com.canddella.entity;

public class FloorDetails {
	private int floorId;
	private String floorNumber;
	private int capacity;
	public FloorDetails(int floorId, String floorNumber, int capacity) {
		super();
		this.floorId = floorId;
		this.floorNumber = floorNumber;
		this.capacity = capacity;
	}
	public FloorDetails() {
		// TODO Auto-generated constructor stub
	}
	public int getFloorId() {
		return floorId;
	}
	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}
	public String getFloorNumber() {
		return floorNumber;
	}
	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}