package com.fly2gether.jetty_jersey.database;
import java.time.LocalDateTime;
//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Date;
import java.util.List;

import com.fly2gether.jetty_jersey.dao.Aircraft;
import com.fly2gether.jetty_jersey.dao.Flight;
import com.fly2gether.jetty_jersey.dao.Passenger;
import com.fly2gether.jetty_jersey.dao.Pilot;
import com.fly2gether.jetty_jersey.dao.Reservation;



public class Database {
	
	private static List<Aircraft> fleet;
	private static List<Flight> flightList;
	private static List<Passenger> totalPassengers;
	private static List<Pilot> totalPilots;
	private static List<Reservation> totalReservations;
	

	public static Database db= new Database("test");
	
	
	public Database() {
		fleet=new ArrayList<Aircraft>();
		flightList=new ArrayList<Flight>();
		totalPassengers=new ArrayList<Passenger>();
		totalPilots=new ArrayList<Pilot>();
	}
	@SuppressWarnings("deprecation")
	public Database(String test) {
		fleet=new ArrayList<Aircraft>();
		flightList=new ArrayList<Flight>();
		totalPassengers=new ArrayList<Passenger>();
		totalPilots=new ArrayList<Pilot>();
		
		Aircraft aircraft1 =new Aircraft("LEARJET40","Boeing",10,1520);
		Passenger passenger1=new Passenger("Hiba","SOUBER","hiba@mail.fr","06XXX",new Date(1999,06,12));
		Pilot pilot1=new Pilot("Rayan","Gosling","rayan@mai;.fr","07XXX",new Date(1980,03,16),200);
		Pilot pilot2=new Pilot("Rayan2","Gosling","rayan@mai;.fr","07XXX",new Date(1980,03,16),200);
		Flight flight1 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 1",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",20,14,pilot1,aircraft1);
		Flight flight2 = new Flight(new Date(2021,03,16),LocalDateTime.of(2021,03,16,18,20,0), "Aerodrome 2",new Date(2021,03,16),LocalDateTime.of(2021,03,16,20,50,0),"Aerodrom2",20,14,pilot1,aircraft1);
		
		fleet.add(aircraft1);
		totalPassengers.add(passenger1);
	totalPilots.add(pilot1);
		totalPilots.add(pilot2);
	flightList.add(flight1);
		
	}
	
	public Database(List<Aircraft> Fleet,List<Passenger> TotalPassengers,List<Pilot> TotalPilots) {
		fleet=Fleet;
		totalPassengers=TotalPassengers;
		totalPilots=TotalPilots;
		flightList=new ArrayList<Flight>();
		totalReservations=new ArrayList<Reservation>();
	}
	
	public static List<Passenger> getTotalPassengers() {		
		return totalPassengers;
	}
	public static List<Aircraft> getFleet() {		
		return fleet;
	}
	public List<Pilot> getToTalPilots(){
		return totalPilots;
	}
	public static List<Flight> getFlightList(){
		return flightList;
	}
	public static List<Reservation> getTotalReservations(){
		return totalReservations;
	}
	
	public void setTotalPassengers(List<Passenger> TotalPassengers) {
		totalPassengers=TotalPassengers;
	}
	public void setTotalPilots(List<Pilot> TotalPilots) {
		totalPilots=TotalPilots;
	}
	public void setFlightList(List<Flight> FlightList) {
		flightList=FlightList;
	}
	public void setFleet(List<Aircraft> Fleet) {
		fleet=Fleet;
	}
	public void setTotalReservations(List<Reservation> TotalReservations) {
		totalReservations=TotalReservations;
	}

}
