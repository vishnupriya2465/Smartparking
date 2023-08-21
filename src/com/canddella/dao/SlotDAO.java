package com.canddella.dao;


import java.util.List;

import com.canddella.entity.FloorDetails;
import com.canddella.entity.Slot;

public interface SlotDAO {
	public void saveSlot(Slot slot);
	public Slot viewSlot(String slotId);
	public Slot deleteSlot(String slotId);
	public List<Slot>listAllSlot();
	public Slot getSlot(String slotId);
	public void updateSlot(String slotId,String newValue,String slotName );


}
