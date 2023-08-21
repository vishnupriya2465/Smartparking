package com.canddella.entity;

public class Slot {
	private String slotId;
	private String slotName;
	public Slot(String slotId, String slotName) {
		super();
		this.slotId = slotId;
		this.slotName = slotName;
	}
	public Slot() {
		// TODO Auto-generated constructor stub
	}
	public String getSlotId() {
		return slotId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	public String getSlotName() {
		return slotName;
	}
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}
	

}
