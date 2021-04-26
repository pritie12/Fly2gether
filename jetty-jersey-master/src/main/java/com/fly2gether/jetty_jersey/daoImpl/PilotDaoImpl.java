package com.fly2gether.jetty_jersey.daoImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import com.fly2gether.jetty_jersey.dao.*;
public class PilotDaoImpl implements pilotDao {
	
	PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
	
	public PilotDaoImpl(PersistenceManagerFactory pmf) {
		this.pmf = pmf;
	}	

	public Map<String, String> getLoginInfo(int Id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(Id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
			pmf.close();
		}
		return detached.getLoginInfo();
	}

	public String getname(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getName();
	}

	public String getsurname(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getSurname();
	}

	public Date getdateOfBirth(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getDateOfBirth();
	}

	public String getemail(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getEmail();
	}

	public String getphoneNumber(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getPhoneNumber();
	}

	public int getFlyingHours(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int Id");
			q.setFilter("Id ==  pilot_id");
			q.setUnique(true);			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached.getFlyingHours();
	}

	public void addPilot(Pilot pilot) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			pm.makePersistent(pilot);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Pilot added to database");
	}

	@SuppressWarnings("unchecked")
	public List<Pilot> getPilots() {
		List<Pilot> pilots=null;
		List<Pilot> detached = new ArrayList<Pilot>();
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			tx.begin();
			Query q = pm.newQuery(Pilot.class);
			pilots = (List<Pilot>) q.execute();
			detached = (List<Pilot>) pm.detachCopyAll(pilots);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

	public void deletePilot(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p=null;
		try {
			tx.begin();
			p = pm.getObjectById(Pilot.class, id);
            pm.deletePersistent(p);
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		System.out.println("Pilot deleted from database");
		
	}

	public Pilot getPilot(int id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		Pilot p = null;
		Pilot detached = null;
		try {
			tx.begin();

			Query q = pm.newQuery(Pilot.class);
			q.declareParameters("int id");
			q.setFilter("id == pilot_id");
			q.setUnique(true);
			
			p = (Pilot) q.execute(id);
			detached = (Pilot) pm.detachCopy(p);

			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
			pm.close();
		}
		return detached;
	}

}
