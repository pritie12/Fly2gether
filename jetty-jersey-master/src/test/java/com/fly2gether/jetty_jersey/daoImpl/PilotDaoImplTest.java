package com.fly2gether.jetty_jersey.daoImpl;

import static org.junit.Assert.*;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

import org.junit.Test;

import com.fly2gether.jetty_jersey.dao.Pilot;

public class PilotDaoImplTest {
/*
	@Test
	public void testPilotDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLoginInfo() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetname() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetsurname() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetdateOfBirth() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetemail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetphoneNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFlyingHours() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testAddPilot() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("Example");
		Pilot p = new Pilot();
		PilotDaoImpl dao = new PilotDaoImpl(pmf);
		try {
		dao.addPilot(p);
		}
		finally{
		fail("fail");
		}
		assertTrue(true);
	}
/*
	@Test
	public void testGetPilots() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePilot() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPilot() {
		fail("Not yet implemented");
	}*/

}
