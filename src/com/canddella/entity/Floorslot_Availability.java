package com.canddella.entity;

public class Floorslot_Availability {
	private String floorslot_AvailabilityId;
	private Floor_Slot floor_slot;
	private String status;
	public Floorslot_Availability(String floorslot_AvailabilityId, Floor_Slot floor_slot, String status) {
		super();
		this.floorslot_AvailabilityId = floorslot_AvailabilityId;
		this.floor_slot = floor_slot;
		this.status = status;
	}
	public Floorslot_Availability() {
		// TODO Auto-generated constructor stub
	}
	public String getFloorslot_AvailabilityId() {
		return floorslot_AvailabilityId;
	}
	public void setFloorslot_AvailabilityId(String floorslot_AvailabilityId) {
		this.floorslot_AvailabilityId = floorslot_AvailabilityId;
	}
	public Floor_Slot getFloor_slot() {
		return floor_slot;
	}
	public void setFloor_slot(Floor_Slot floor_slot) {
		this.floor_slot = floor_slot;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	}
	
	
	


