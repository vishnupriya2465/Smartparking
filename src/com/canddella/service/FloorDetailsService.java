package com.canddella.service;

import java.util.List;

import com.canddella.entity.FloorDetails;

public interface FloorDetailsService {
	public void saveFloorDetails(FloorDetails floordetails);
	public FloorDetails viewFloorDetails(int floorId);
	public FloorDetails deleteFloorDetails(int floorId);
	public List<FloorDetails> listAllFloorDetails();
	public FloorDetails getFloorDetails(int floorId);
	public void updateFloorDetails(int floorId,String floorStore, String floorNumber );



}
