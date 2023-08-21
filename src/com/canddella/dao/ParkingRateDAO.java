package com.canddella.dao;

import java.util.List;

import com.canddella.entity.ParkingRate;



public interface ParkingRateDAO {
	public void saveParkingRate(ParkingRate parkingrate);
	public ParkingRate viewParkingRate(String rateId);
	public ParkingRate deleteParkingRate(String rateId);
	public List<ParkingRate>listAllParkingRate();

}
