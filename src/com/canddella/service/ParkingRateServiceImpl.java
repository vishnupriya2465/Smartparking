package com.canddella.service;

import java.util.List;

import com.canddella.dao.ParkingRateDAOImpl;
import com.canddella.entity.ParkingRate;

public class ParkingRateServiceImpl implements ParkingRateService {
	ParkingRateDAOImpl parkingratedaoimpl = new ParkingRateDAOImpl ();

	@Override
	public void saveParkingRate(ParkingRate parkingrate) {
		parkingratedaoimpl.saveParkingRate(parkingrate);
		
	}

	@Override
	public ParkingRate viewParkingRate(String parkingrateId) {
		return parkingratedaoimpl.viewParkingRate(parkingrateId);
	}

	@Override
	public ParkingRate deleteParkingRate(String parkingrateId) {
		return parkingratedaoimpl.deleteParkingRate(parkingrateId);
	}

	@Override
	public List<ParkingRate> listAllParkingRate() {
		return parkingratedaoimpl.listAllParkingRate();
	}

}
