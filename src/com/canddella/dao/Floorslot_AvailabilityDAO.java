package com.canddella.dao;

import java.util.List;

import com.canddella.entity.Floorslot_Availability;

public interface Floorslot_AvailabilityDAO {
	public void saveFloorslot_Availability(Floorslot_Availability floorslot_Availability);
	public Floorslot_Availability viewFloorslot_Availability(String floorslot_AvailabilityId);
	public Floorslot_Availability deleteFloorslot_Availability(String floorslot_AvailabilityId);
	public List<Floorslot_Availability>listAllFloorslot_Availability();

	
}
