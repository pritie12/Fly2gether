package com.fly2gether.jetty_jersey.dao;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class DAO implements flightDao,aircraftDao,piloteDao,passengerDao{
	
	public List<Aircraft> fleet;
	public List<Flight> flightList;
	public List<Passenger> totalPassengers;
	public List<Pilot> totalPilots;
	
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

	 
	public List<Pilot> getPilots() {		
		return totalPilots;
	}

	 
	public List<Pilot> getPilots(Duration experience) {
		List<Pilot> pil=new ArrayList<Pilot>();
		for(Pilot p:totalPilots) {
			if(p.experience.compareTo(experience)>0) {
				pil.add(p);
			}
		}
		return pil;
	}

	 
	public void addPilot(Pilot pilot) {
		totalPilots.add(pilot);
		
	}

	 
	public void deletePilot(Pilot pilot) {
		totalPilots.remove(pilot);
		
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

	 
	public String getPilotId(Pilot pilot) {
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

	 
	public Pilot getPilot(Flight flight) {
		return flight.pilot;
	}

	 
	public int getPrice(Flight flight) {
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

	public String getname(Pilot pilot) {
		
		return pilot.name;
	}

	public String getsurname(Pilot pilot) {

		return pilot.surname;
	}

	public Date getdateOfBirth(Pilot pilot) {
		return pilot.dateOfBirth;
	}

	public String getemail(Pilot pilot) {
		return pilot.email;
	}

	public String getphoneNumber(Pilot pilot) {
		return pilot.phoneNumber;
	}

	public Date getstartingDate(Pilot pilot) {
		return pilot.startingDate;
	}

	public Duration getexperience(Pilot pilot) {
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
