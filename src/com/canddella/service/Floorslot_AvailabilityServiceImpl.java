package com.canddella.service;

import java.util.List;

import com.canddella.dao.Floorslot_AvailabilityDAOImpl;
import com.canddella.entity.Floorslot_Availability;

public class Floorslot_AvailabilityServiceImpl implements Floorslot_AvailabilityService {
	Floorslot_AvailabilityDAOImpl floorslot_Availabilitydaoimpl = new Floorslot_AvailabilityDAOImpl ();

	@Override
	public void saveFloorslot_Availability(Floorslot_Availability floorslot_Availability) {
		floorslot_Availabilitydaoimpl.saveFloorslot_Availability(floorslot_Availability);	
		
		
	}

	@Override
	public Floorslot_Availability viewFloorslot_Availability(String floorslot_AvailabilityId) {
		return floorslot_Availabilitydaoimpl.viewFloorslot_Availability(floorslot_AvailabilityId);
	}

	@Override
	public Floorslot_Availability deleteFloorslot_Availability(String floorslot_AvailabilityId) {
		
		return floorslot_Availabilitydaoimpl.deleteFloorslot_Availability(floorslot_AvailabilityId);
	}

	@Override
	public List<Floorslot_Availability> listAllFloorslot_Availability() {
		
		return floorslot_Availabilitydaoimpl.listAllFloorslot_Availability();
	}

}
