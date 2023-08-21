package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Customer;
import com.canddella.entity.Floor_Slot;



public interface Floor_SlotDAO {
	public void saveFloor_Slot(Floor_Slot floor_slot);
	public Floor_Slot viewFloor_Slot(int floor_slotId);
	public Floor_Slot deleteFloor_Slot(int floor_slotId);
	public List<Floor_Slot>listAllFloor_Slot();

}
