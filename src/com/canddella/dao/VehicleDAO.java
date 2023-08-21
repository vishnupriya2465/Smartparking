package com.canddella.dao;


import java.util.List;


import com.canddella.entity.Vehicle;

public interface VehicleDAO {
	public void saveVehicle(Vehicle vehicle);
	public Vehicle viewVehicle(int vehicleId);
	public Vehicle deleteVehicle(int vehicleId);
	public List<Vehicle>listAllVehicle();

}
