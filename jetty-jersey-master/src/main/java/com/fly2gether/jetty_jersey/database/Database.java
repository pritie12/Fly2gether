package com.fly2gether.jetty_jersey.database;
import java.util.ArrayList;
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
	
	
	public Database() {
		fleet=new ArrayList<Aircraft>();
		flightList=new ArrayList<Flight>();
		totalPassengers=new ArrayList<Passenger>();
		totalPilots=new ArrayList<Pilot>();
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
	public static List<Pilot> getToTalPilots(){
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
