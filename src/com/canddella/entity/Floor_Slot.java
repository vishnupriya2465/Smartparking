package com.canddella.entity;

public class Floor_Slot {
	private int Floor_SlotId;
	private FloorDetails floordetails;
	private Slot slot;
	public Floor_Slot(int floor_SlotId, FloorDetails floordetails, Slot slot) {
		super();
		Floor_SlotId = floor_SlotId;
		this.floordetails = floordetails;
		this.slot = slot;
	}
	public Floor_Slot() {
		// TODO Auto-generated constructor stub
	}
	public int getFloor_SlotId() {
		return Floor_SlotId;
	}
	public void setFloor_SlotId(int floor_SlotId) {
		Floor_SlotId = floor_SlotId;
	}
	public FloorDetails getFloordetails() {
		return floordetails;
	}
	public void setFloordetails(FloorDetails floordetails) {
		this.floordetails = floordetails;
	}
	public Slot getSlot() {
		return slot;
	}
	public void setSlot(Slot slot) {
		this.slot = slot;
	}
	

}
