package com.canddella.service;




import java.util.List;


import com.canddella.entity.Slot;

public interface SlotService {
	public void saveSlot(Slot slot);
	public Slot viewSlot(String slotId);
	public Slot deleteSlot(String slotId);
	public List<Slot> listAllSlot();
	public Slot getSlot(String slotId);
	public void updateSlot(String slotId,String newValue,String slotName);


}
