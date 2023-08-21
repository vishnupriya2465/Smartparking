package com.canddella.service;

import java.util.List;

import com.canddella.entity.Floor_Slot;
import com.canddella.entity.Floorslot_Availability;
import com.canddella.entity.Reservation;



public interface ReservationService {
	public void saveReservation(Reservation reservation);
	public Reservation viewReservation(String reservationId);
	public Reservation deleteReservation(String reservationId);
	public List<Reservation> listAllReservation();
	public Floorslot_Availability	 Totalavailability(Floor_Slot floor_slot);

}
