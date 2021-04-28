package com.fly2gether.jetty_jersey.JunitTest;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.fly2gether.jetty_jersey.dao.Aircraft;

@PersistenceCapable
public class AircraftContainer {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	protected Long id = null;

	@Persistent
	protected List<Aircraft> fleet = null;

	public AircraftContainer() {
		super();
		this.fleet = new ArrayList<Aircraft>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Aircraft> getFleet() {
		return fleet;
	}

	public void setActions(List<Aircraft> fleet) {
		this.fleet = fleet;
	}

}