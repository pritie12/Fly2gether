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

	public Passenger getbookingUser(int reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("int reservation_id");
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

	public int getdesiredSeats(int reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("int reservation_id");
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

	public Flight getFlight(int reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("int reservation_id");
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

	public List<Integer> getReservations(int passenger_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		List<Integer> passengers_reservations=null;
		List<Integer> detached=null;
		try {
			tx.begin();
			
			Passenger p = pm.getObjectById(Passenger.class, passenger_id);
			passengers_reservations=p.getPassengerBookingList();

			detached = (List<Integer>) pm.detachCopy(passengers_reservations);		
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
		}
		return detached;
	}
	public boolean getStatus(int reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("int reservation_id");
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
	
	public void changeNumberOfSeats(int seats,int reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Reservation r = pm.getObjectById(Reservation.class, reservation_id);
			r.setDesiredSeats(seats);		
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
		try {
			tx.begin();
			pm.makePersistent(reservation);
			tx.commit();
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
			Query q = pm.newQuery(Aircraft.class);

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

	public Reservation getReservation(int reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r = null;
		Reservation detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Reservation.class);
			q.declareParameters("int reservation_id");
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

	public void deleteReservation(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r=null;
		try {
			tx.begin();
			r = pm.getObjectById(Reservation.class, id);
            pm.deletePersistent(r);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Reservation deleted from database");
		
	}


	public void denyReservation(int reservation_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Reservation r=null;
		try {
			tx.begin();
			r = pm.getObjectById(Reservation.class, reservation_id);
            r.setStatus(false);
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
