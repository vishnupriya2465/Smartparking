package com.canddella.service;

import java.util.List;

import com.canddella.entity.ParkingRate;




public interface ParkingRateService {
	public void saveParkingRate(ParkingRate parkingrate);
	public ParkingRate viewParkingRate(String parkingrateId);
	public ParkingRate deleteParkingRate(String parkingrateId);
	public List<ParkingRate> listAllParkingRate();

}
