package com.canddella.service;

import java.util.List;

import com.canddella.dao.SlotDAOImpl;
import com.canddella.entity.FloorDetails;
import com.canddella.entity.Slot;

public class SlotServiceImpl implements SlotService {
	SlotDAOImpl slotdaoimpl = new SlotDAOImpl ();

	@Override
	public void saveSlot(Slot slot) {
		slotdaoimpl.saveSlot(slot);
		
		
	}

	@Override
	public Slot viewSlot(String slotId) {
		return slotdaoimpl.viewSlot(slotId);
	}

	@Override
	public Slot deleteSlot(String slotId) {
		
		return slotdaoimpl.deleteSlot(slotId);
	}
	@Override
	public List<Slot> listAllSlot() {
		
		return slotdaoimpl.listAllSlot() ;
	}




	@Override
	public void updateSlot(String slotName,String newValue, String slotId) {
		slotdaoimpl.updateSlot(slotName,newValue, slotId);
		
		
	}
	@Override
	public Slot getSlot(String slotId) {
		Slot slot=slotdaoimpl.getSlot(slotId);
		
		return slot;
	}

	
	

}