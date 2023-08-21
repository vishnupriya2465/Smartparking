package com.canddella.service;


import java.util.List;

import com.canddella.dao.Floor_SlotDAOImpl;
import com.canddella.entity.Floor_Slot;

public class Floor_SlotServiceImpl implements Floor_SlotService {
	Floor_SlotDAOImpl floor_slotdaoimpl = new Floor_SlotDAOImpl ();


	@Override
	public void saveFloor_Slot(Floor_Slot floor_slot) {
		floor_slotdaoimpl.saveFloor_Slot(floor_slot);
		
		
		
	}


	@Override
	public Floor_Slot viewFloor_Slot(int floor_slotId) {
		return floor_slotdaoimpl.viewFloor_Slot(floor_slotId);
		
	}


	@Override
	public List<Floor_Slot> listAllFloor_Slot() {
		return floor_slotdaoimpl.listAllFloor_Slot();
	}


	@Override
	public Floor_Slot deleteFloor_Slot(int floor_slotId) {
		
		return floor_slotdaoimpl.deleteFloor_Slot(floor_slotId);
	}
	

}
