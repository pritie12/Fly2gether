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
		//aircraft1.setTailNumber(123);
		aircraft1.setModel("MARSUPILAMI11");
		aircraft1.setNumberOfSeats(30);

		aircraftDao.addAircraft(aircraft1);
		
		Aircraft aircraft2 = new Aircraft();
		System.out.println(aircraftDao.getFleet().get(0).getTailNumber());
		//aircraft2.setTailNumber(265);
		aircraft2.setModel("PHOENIX89");
		aircraft2.setConstructorCompany("Airbus");
		aircraft2.setNumberOfSeats(60);		
		aircraftDao.addAircraft(aircraft2);
		
		Assert.assertEquals(2, aircraftDao.getFleet().size());
		System.out.println(aircraftDao.getFleet().get(0).getTailNumber());		
		System.out.println(aircraftDao.getFleet().get(1).getModel());
		System.out.println(aircraftDao.getFleet().size());

		aircraftDao.deleteAircraft(aircraftDao.getFleet().get(1).getTailNumber());
		System.out.println(aircraftDao.getFleet().size());
		//Assert.assertEquals(1, aircraftDao.getFleet().size());

		DAO.getAircraftDao().getFleet();
	}


}
