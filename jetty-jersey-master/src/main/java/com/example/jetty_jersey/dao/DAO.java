package com.example.jetty_jersey.dao;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.jetty_jersey.dao.Aircraft;

public class DAO implements flightDao,aircraftDao,piloteDao,passengerDao{
	
	List<Aircraft> fleet;
	List<Flight> flightList;
	List<Passenger> totalPassengers;
	List<Pilote> totalPilotes;
	
	public List<Passenger> getPassengers() {		
		return totalPassengers;
	}

	public List<Passenger> getPassengers(Flight flight) {
		return flight.passengers;
	}

	public List<Passenger> getPassengers(Date Time, String Airport) {
		List<Passenger> pass=new ArrayList<Passenger>();
		for(Flight f:flightList) {
			for(Passenger p:totalPassengers) {
				if((f.departureDateTime.equals(Time)&&f.departureAirport.equals(Airport))||(f.arrivalDateTime.equals(Time)&&f.arrivalAirport.equals(Airport)))
					pass.add(p);
			}
		}
		return pass;
	}

	public void addPassenger(Passenger passenger, Flight flight) {
		for (Flight f : flightList){
			if(f.equals(flight)) {
				f.passengers.add(passenger);
			}			
		}
	}

	 
	public void deletePassenger(Passenger passenger, Flight flight) {
		for (Flight f : flightList){
			if(f.equals(flight)) {
				f.passengers.remove(passenger);
			}			
		}
	}

	 
	public List<Pilote> getPilotes() {		
		return totalPilotes;
	}

	 
	public List<Pilote> getPilotes(Duration experience) {
		List<Pilote> pil=new ArrayList<Pilote>();
		for(Pilote p:totalPilotes) {
			if(p.experience.compareTo(experience)>0) {
				pil.add(p);
			}
		}
		return pil;
	}

	 
	public void addPilot(Pilote pilot) {
		totalPilotes.add(pilot);
		
	}

	 
	public void deletePilot(Pilote pilot) {
		totalPilotes.remove(pilot);
		
	}

	 
	public List<Aircraft> getAircrafts() {
		return fleet;
	}


	 
	public List<Flight> getFlights() {
		return flightList;
	}

	 
	public List<Flight> getFlights(int minPrice, int maxPrice) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flightList) {
				if(f.price>=minPrice&&f.price<=maxPrice)
					fli.add(f);
		}
		return fli;
	}

	 
	public List<Flight> getFlights(Date DepartureTime, String DepartureAirport) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flightList) {
				if(f.departureDateTime.equals(DepartureTime)&&f.departureAirport.equals(DepartureAirport))
					fli.add(f);
		}
		return fli;
	}

	 
	public List<Flight> getFlights(Date DepartureTime, String DepartureAirport, Date ArrivalTime,
			String ArrivalAirport) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flightList) {
				if(f.departureDateTime.equals(DepartureTime)&&f.departureAirport.equals(DepartureAirport)
						&&f.arrivalDateTime.equals(ArrivalTime)&&f.arrivalAirport.equals(ArrivalAirport))
					fli.add(f);
		}
		return fli;
	}

	 
	public List<Flight> getFlights(int availableSeats) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flightList) {
			if(f.availablesSeats>=availableSeats) {
				fli.add(f);
			}
		}
		return fli;
	}

	 
	public void addFlight(Flight flight) {
		flightList.add(flight);
		
	}

	 
	public void deleteFlight(Flight flight) {
		flightList.remove(flight);
		
	}

	 
	public String getPilotId(Pilote pilot) {
		return pilot.id;
	}

	 
	public String getTailNumber(Aircraft aircraft) {
		return aircraft.tailNumber;
	}

	 
	public void addAircraft(Aircraft aircraft) {
		fleet.add(aircraft);
		
	}

	 
	public void removeAircraft(Aircraft aircraft) {
		fleet.remove(aircraft);
		
	}

	 
	public Pilote getPilot(Flight flight) {
		return flight.pilot;
	}

	 
	public double getPrice(Flight flight) {
		return flight.price;
	}

	 
	public int getAvailableSeats(Flight flight) {
		return flight.availablesSeats;
	}

	public String getModel(Aircraft aircraft) {
		return aircraft.model;
	}

	public int getFlyingHours(Aircraft aircraft) {
		return aircraft.flyingHours;
	}

	public String getCompany(Aircraft aircraft) {
		return aircraft.constructorCompany;
	}

	public int getNumberOfSeats(Aircraft aircraft) {
		return aircraft.numberOfSeats;
	}

	public String getId(Flight flight) {
		return flight.id;
	}

	public String getAppointmentDescription(Flight flight) {
		return flight.appointmentDescription;
	}

	public Date getdepartureDateTime(Flight flight) {
		return flight.departureDateTime;
	}

	public String getdepartureAirport(Flight flight) {
		return flight.departureAirport;
	}

	public Date getarrivalDateTime(Flight flight) {

		return flight.arrivalDateTime;
	}

	public String getarrivalAirport(Flight flight) {
		return flight.arrivalAirport;
	}

	public Aircraft getAircraft(Flight flight) {
		return flight.aircraft;
	}

	public String getname(Pilote pilot) {
		
		return pilot.name;
	}

	public String getsurname(Pilote pilot) {

		return pilot.surname;
	}

	public Date getdateOfBirth(Pilote pilot) {
		return pilot.dateOfBirth;
	}

	public String getemail(Pilote pilot) {
		return pilot.email;
	}

	public String getphoneNumber(Pilote pilot) {
		return pilot.phoneNumber;
	}

	public Date getstartingDate(Pilote pilot) {
		return pilot.startingDate;
	}

	public Duration getexperience(Pilote pilot) {
		return pilot.experience;
	}

	public String getPassengerId(Passenger passenger) {
		return passenger.id;
	}

	public String getname(Passenger passenger) {
		return passenger.name;
	}

	public String getsurname(Passenger passenger) {
		return passenger.surname;
	}

	public Date getdateOfBirth(Passenger passenger) {
		return passenger.dateOfBirth;
	}

	public String getemail(Passenger passenger) {
		return passenger.email;
	}

	public String getphoneNumber(Passenger passenger) {

		return passenger.phoneNumber;
	}

	public List<Reservation> getpassengerBookingList(Passenger passenger) {
		return passenger.passengerBookingList;
	}

}
