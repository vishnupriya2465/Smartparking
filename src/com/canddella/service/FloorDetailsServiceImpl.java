package com.canddella.service;

import java.util.List;

import com.canddella.dao.FloorDAOImpl;
import com.canddella.entity.FloorDetails;

public class FloorDetailsServiceImpl implements FloorDetailsService {
	FloorDAOImpl floordaoimpl = new FloorDAOImpl();

	@Override
	public void saveFloorDetails(FloorDetails floordetails) {
		
		 floordaoimpl.saveFloorDetails(floordetails);
	}

	@Override
	public FloorDetails viewFloorDetails(int floorId) {
		
		return floordaoimpl.viewFloorDetails(floorId);
	}

	@Override
	public FloorDetails deleteFloorDetails(int floorId) {
		
		return floordaoimpl.deleteFloorDetails(floorId);
	}

	@Override
	public List<FloorDetails> listAllFloorDetails() {
		
		return floordaoimpl.listAllFloorDetails();
	}



	@Override
	public void updateFloorDetails( int floorId,String floorStore, String floornumber) {
		
		floordaoimpl.updateFloorDetails(floorId, floorStore,  floornumber);
	}
	@Override
	public FloorDetails getFloorDetails(int floorId) {
		// TODO Auto-generated method stub
		FloorDetails floordetails = floordaoimpl.getFloorDetails(floorId);
		return floordaoimpl.getFloorDetails(floorId) ;
	}

	
	

}
