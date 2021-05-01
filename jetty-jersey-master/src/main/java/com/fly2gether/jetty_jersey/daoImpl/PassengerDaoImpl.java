package com.fly2gether.jetty_jersey.daoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.fly2gether.jetty_jersey.dao.*;
public class PassengerDaoImpl implements passengerDao{

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
	
	public PassengerDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	@SuppressWarnings("unchecked")
	public List<Passenger> getPassengers(){
		List<Passenger> passengers=null;
		List<Passenger> detached = new ArrayList<Passenger>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);

			passengers = (List<Passenger>) q.execute();
			detached = (List<Passenger>) pm.detachCopyAll(passengers);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}
	
	public Passenger getPassenger(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int id");
			q.setFilter("id == passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}
	public String getUsername(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getUsername();
	}
	public String getPwd(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getPwd();
	}
	public String getname(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getName();
	}

	public String getsurname(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getSurname();
	}

	public Date getdateOfBirth(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getDateOfBirth();
	}

	public String getemail(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached.getEmail();
	}

	public String getphoneNumber(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getPhoneNumber();
	}

	public List<Long> getpassengerBookingList(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p = null;
		Passenger detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("Long Id");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);
			
			p = (Passenger) q.execute(Id);
			detached = (Passenger) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getPassengerBookingList();
	}

	public void addPassenger(Passenger passenger) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			Query q = pm.newQuery(Passenger.class);
			q.declareParameters("String Username");
			q.setFilter("Id ==  passenger_id");
			q.setUnique(true);			
			pm.makePersistent(passenger);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}	
		System.out.println("Passenger added to database");
		
	}

	public void addReservation(Long passenger_id, Long resa_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			
			Passenger p = pm.getObjectById(Passenger.class, passenger_id);
			if(p. getPassengerBookingList().contains(resa_id)) {
				p.getPassengerBookingList().add(resa_id);
			}
			
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
		}
		System.out.println("Reservation added");
		
	}

	public void cancelReservation(Long passenger_id, Long resa_id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			
			Passenger p = pm.getObjectById(Passenger.class, passenger_id);
			if(p. getPassengerBookingList().contains(resa_id)) {
				p.getPassengerBookingList().remove(resa_id);
			}
			
			tx.commit();
		} finally {
			if (tx.isActive()) tx.rollback();
			pm.close();
			pmf.close();
		}
		System.out.println("Reservation canceled");
		
	}

	public void deletePassenger(Long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, id);
            pm.deletePersistent(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		System.out.println("Passenger deleted from database");
		
	}

	public Passenger Login(String username, String password) {
		Passenger passenger=getPassenger(username);
		if(passenger==null) {
			System.out.println("Username not found");
			return null;
		}
		if(passenger.getPwd().equals(password)) {
			return passenger;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Passenger getPassenger(String username) {
        List<Passenger> result;
        Passenger passenger;

        PersistenceManager pm = pmf.getPersistenceManager();

        Query q = pm.newQuery(Passenger.class, "username.equals(\"" + username + "\")");

        result = (List<Passenger>) q.execute();
        try {
            passenger = (Passenger) result.iterator().next();
        } catch (NoSuchElementException | IndexOutOfBoundsException e) {
            return null;

        }
        q.close(result);

        return passenger;
	}

	public void modifyUsername(Long id, String Username) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, id);

            p.setUsername(Username);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		
	}

	public void modifyPwd(Long id, String Pwd) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Passenger p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Passenger.class, id);
            p.setPwd(Pwd);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
	}


}
