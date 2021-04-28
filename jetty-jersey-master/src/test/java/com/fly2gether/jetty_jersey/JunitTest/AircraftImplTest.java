package com.fly2gether.jetty_jersey.JunitTest;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Assert;
import org.junit.Test;

import com.fly2gether.jetty_jersey.dao.Aircraft;
import com.fly2gether.jetty_jersey.dao.DAO;
import com.fly2gether.jetty_jersey.dao.aircraftDao;
import com.fly2gether.jetty_jersey.daoImpl.AircraftDaoImpl;



public class AircraftImplTest {

	@Test
	public void test() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Fly2gether");
		aircraftDao aircraftDao = new AircraftDaoImpl(pmf);

		Assert.assertEquals(0, aircraftDao.getFleet().size());

		Aircraft aircraft1 = new Aircraft();
		aircraft1.setTailNumber(123);
		System.out.println(aircraft1.getTailNumber());
		aircraft1.setModel("MARSUPILAMI11");
		aircraft1.setNumberOfSeats(30);

		aircraftDao.addAircraft(aircraft1);
		
		Aircraft aircraft2 = new Aircraft();

		aircraft2.setTailNumber(265);
		aircraft2.setModel("PHOENIX89");
		aircraft2.setConstructorCompany("Airbus");
		aircraft2.setNumberOfSeats(60);		
		aircraftDao.addAircraft(aircraft2);
		// test add
		Assert.assertEquals(2, aircraftDao.getFleet().size());

        Aircraft aircraft3 =new Aircraft("LEARJET70","Boeing",50,1582);
        Aircraft aircraft4 =new Aircraft("FLYFLY58","Airbus",100,1334);
        Aircraft aircraft5 =new Aircraft("MARSUPILAMI12","Lockheed Martin",70,1423);
		Aircraft aircraft6 =new Aircraft("LEARJET40","Boeing",10,5482);
        Aircraft aircraft7 =new Aircraft("LEARJET45","Boeing",28,5987);
 
		aircraftDao.addAircraft(aircraft3);
		System.out.println(aircraftDao.getFleet().get(1).getTailNumber());
		aircraftDao.addAircraft(aircraft4);
		aircraftDao.addAircraft(aircraft5);
		aircraftDao.addAircraft(aircraft6);
		aircraftDao.addAircraft(aircraft7);
		
		aircraftDao.deleteAircraft(aircraftDao.getFleet().get(0).getTailNumber());
		
		System.out.println(aircraftDao.getFleet().get(0).getTailNumber());	
		System.out.println(aircraftDao.getFleet().get(1).getTailNumber());	
		System.out.println(aircraftDao.getFleet().get(2).getTailNumber());	
		System.out.println(aircraftDao.getFleet().get(3).getTailNumber());	
		System.out.println(aircraftDao.getFleet().get(4).getTailNumber());	
		System.out.println(aircraftDao.getFleet().get(5).getTailNumber());	
		
		// test add + delete 
		Assert.assertEquals(6, aircraftDao.getFleet().size());
		// test get
		Assert.assertEquals("PHOENIX89", aircraftDao.getModel(1));
		Assert.assertEquals("LEARJET40", aircraftDao.getModel(5));
		
		DAO.getAircraftDao().getFleet();
		
	}

}
