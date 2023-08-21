package com.canddella.service;

import java.util.List;

import com.canddella.dao.VehicleDAOImpl;
import com.canddella.entity.Vehicle;

public class VehicleServiceImpl implements VehicleService {
	VehicleDAOImpl vehicledaoimpl = new VehicleDAOImpl ();

	@Override
	public void saveVehicle(Vehicle vehicle) {
		vehicledaoimpl.saveVehicle(vehicle);
		
		
	}

	@Override
	public Vehicle viewVehicle(int vehicleId) {
		
		return vehicledaoimpl.viewVehicle(vehicleId);
	}

	@Override
	public Vehicle deleteVehicle(int vehicleId) {
		return vehicledaoimpl.deleteVehicle(vehicleId);
	}

	@Override
	public List<Vehicle> listAllVehicle() {
		
		return vehicledaoimpl.listAllVehicle();
	}

	
	}


