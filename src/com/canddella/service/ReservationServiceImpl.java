package com.canddella.service;


import java.util.List;

import com.canddella.dao.ReservationDAOImpl;
import com.canddella.entity.Floor_Slot;
import com.canddella.entity.Floorslot_Availability;
import com.canddella.entity.Reservation;

public class ReservationServiceImpl implements ReservationService {
	ReservationDAOImpl reservationdaoimpl = new ReservationDAOImpl();

	@Override
	public void saveReservation(Reservation reservation) {
		reservationdaoimpl.saveReservation(reservation);
		
		
		
	}

	@Override
	public Reservation viewReservation(String reservationId) {
		return reservationdaoimpl.viewReservation(reservationId);
		
	}

	@Override
	public Reservation deleteReservation(String reservationId) {
		return reservationdaoimpl.deleteReservation(reservationId);
	}

	@Override
	public List<Reservation> listAllReservation() {
		return reservationdaoimpl.listAllReservation();
	}

	@Override
	public Floorslot_Availability Totalavailability(Floor_Slot floor_slot) {
		return reservationdaoimpl.Totalavailability(floor_slot);
	}

}
