package com.fly2gether.jetty_jersey.daoImpl;
import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.fly2gether.jetty_jersey.dao.*;

public class ReservationDaoImpl implements reservationDao{

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
	
	public ReservationDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}	

	public Long getbookingUser(Long reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("Long reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getBookingUser();
	}

	public int getdesiredSeats(Long reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("Long reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getDesiredSeats();
	}

	public Long getFlight(Long reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("Long reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getFlight();
	}

	public List<Long> getReservations(Long passenger_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Long> passengers_reservations=null;
		List<Long> detached=null;
		try {
			tx.begin();
			
			Passenger p = pm.getObjectById(Passenger.class, passenger_id);
			passengers_reservations=p.getPassengerBookingList();

			detached = (List<Long>) pm.detachCopy(passengers_reservations);		
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
		}
		return detached;
	}
	public boolean getStatus(Long reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("Long reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getStatus();
	}
	
	public void changeNumberOfSeats(int seats,Long reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Reservation r = pm.getObjectById(Reservation.class, reservation_id);
			int oldseats=r.getDesiredSeats();
			r.setDesiredSeats(seats);	
			Flight f = pm.getObjectById(Flight.class, r.getFlight());
			f.setAvailableSeats((f.getAvailableSeats()-(r.getDesiredSeats()-oldseats)));
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
		}
		System.out.println("Number of seats changed to: "+seats);
	}
	
	public void addReservation(Reservation reservation) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Flight f=null;
		tx.setRetainValues(true);
		try {
			tx.begin();
			f = pm.getObjectById(Flight.class, reservation.getFlight());
			f.setAvailableSeats((f.getAvailableSeats()-reservation.getDesiredSeats()));
			//reservation.getFlight().setAvailableSeats((reservation.getFlight().getAvailableSeats()-reservation.getDesiredSeats()));
			pm.makePersistent(reservation);
			tx.commit();
			//System.out.println("Flight for "+reservation.getBookingUser().getName()+" "+reservation.getBookingUser().getSurname()+" booked");
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();		
		}		
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> getReservations() {
		List<Reservation> reservations=null;
		List<Reservation> detached = new ArrayList<Reservation>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Reservation.class);

			reservations = (List<Reservation>) q.execute();
			detached = (List<Reservation>) pm.detachCopyAll(reservations);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public Reservation getReservation(Long reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("Long reservation_id");
			q.setFilter("reservation_id == resa_id");
			q.setUnique(true);
			
			r = (Reservation) q.execute(reservation_id);
			detached = (Reservation) pm.detachCopy(r);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}


	public void denyReservation(Long reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r=null;
		try {
			tx.begin();
			r = pm.getObjectById(Reservation.class, reservation_id);
            pm.deletePersistent(r);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Reservation denied");	
	}

}
