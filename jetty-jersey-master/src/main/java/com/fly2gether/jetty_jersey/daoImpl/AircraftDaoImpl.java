package com.fly2gether.jetty_jersey.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.fly2gether.jetty_jersey.dao.*;

public class AircraftDaoImpl implements aircraftDao{

	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
	
	public AircraftDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}
	
	/* GETTERS */
	
	@SuppressWarnings("unchecked")
	public List<Aircraft> getFleet() {	
		List<Aircraft> aircrafts=null;
		List<Aircraft> detached = new ArrayList<Aircraft>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			Query q = pm.newQuery(Aircraft.class);

			aircrafts = (List<Aircraft>) q.execute();
			detached = (List<Aircraft>) pm.detachCopyAll(aircrafts);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached;		
	}
	
	
	
	public String getModel(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("long TailNumber");
			q.setFilter("TailNumber == tailNumber");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(Id);
			detached = (Aircraft) pm.detachCopy(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getModel();
	}
	
	
	public String getCompany(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int Id");
			q.setFilter("Id == aircraft_id");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(Id);
			detached = (Aircraft) pm.detachCopy(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getConstructorCompany();
	}

	public int getNumberOfSeats(Long Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("int Id");
			q.setFilter("Id == aircraft_id");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(Id);
			detached = (Aircraft) pm.detachCopy(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached.getNumberOfSeats();
	}
	
	public long getAircraftId(Long tailNum) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("long tailNum");
			q.setFilter("tailNum == tailNumber");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(tailNum);
			detached = (Aircraft) pm.detachCopy(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached.getID();
	}

	public Aircraft getAircraft(Long TailNumber) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a = null;
		Aircraft detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long TailNumber");
			q.setFilter("TailNumber == tailNumber");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(TailNumber);
			detached = (Aircraft) pm.detachCopy(a);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();

		}
		return detached;
	}
	
	/* POST */

	public void setModel(Long TailNumber, String Model) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a=null;
		try {
			tx.begin();
			a = pm.getObjectById(Aircraft.class, TailNumber);

            a.setModel(Model);;
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
	}



	
	public void setCompany(Long TailNumber, String Company) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a=null;
		try {
			tx.begin();
			a = pm.getObjectById(Aircraft.class, TailNumber);
			
			

            a.setConstructorCompany(Company);;
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
	}
	/*public Aircraft getAircraft(Long Id) {
		Query q = pm.newQuery(Aircraft.class);
		q.declareParameters("Long Id");
		q.setFilter("Id == aircraft_id");
		q.setUnique(true);
		
		a = (Aircraft) q.execute(Id);
		detached = (Aircraft) pm.detachCopy(a);
	}*/

	public void setNumberOfSeats(Long Id, int NumberOfSeats) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a=null;
		try {
			tx.begin();
			a = pm.getObjectById(Aircraft.class, Id);

            a.setNumberOfSeats(NumberOfSeats);;
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
	}



		
	
	/* PUT */
	public void addAircraft(Aircraft aircraft) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		tx.setRetainValues(true);
		try {
			tx.begin();
			pm.makePersistent(aircraft);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}		
	}


	/* DELETE */
	public void deleteAircraft(Long TailNumber) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Aircraft a=null;
		try {
			tx.begin();
			//a = pm.getObjectById(Aircraft.class, TailNumber);
			Query q = pm.newQuery(Aircraft.class);
			q.declareParameters("Long TailNumber");
			q.setFilter("TailNumber == tailNumber");
			q.setUnique(true);
			
			a = (Aircraft) q.execute(TailNumber);

            pm.deletePersistent(a);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Aircraft deleted from database");		
	}

	
}
