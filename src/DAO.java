import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class DAO implements flightDao,aircraftDao,piloteDao,passengerDao{
	
	List<Aircraft> fleet;
	List<Flight> flightList;
	List<Passenger> totalPassengers;
	List<Pilote> totalPilotes;
	
	@Override
	public List<Passenger> getPassengers() {		
		return totalPassengers;
	}

	@Override
	public List<Passenger> getPassengers(Flight flight) {
		return flight.passengers;
	}

	@Override
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

	@Override
	public void addPassenger(Passenger passenger, Flight flight) {
		for (Flight f : flightList){
			if(f.equals(flight)) {
				f.passengers.add(passenger);
			}			
		}
	}

	@Override
	public void deletePassenger(Passenger passenger, Flight flight) {
		for (Flight f : flightList){
			if(f.equals(flight)) {
				f.passengers.remove(passenger);
			}			
		}
	}

	@Override
	public List<Pilote> getPilotes() {		
		return totalPilotes;
	}

	@Override
	public List<Pilote> getPilotes(Duration experience) {
		List<Pilote> pil=new ArrayList<Pilote>();
		for(Pilote p:totalPilotes) {
			if(p.experience.compareTo(experience)>0) {
				pil.add(p);
			}
		}
		return pil;
	}

	@Override
	public void addPilot(Pilote pilot) {
		totalPilotes.add(pilot);
		
	}

	@Override
	public void deletePilot(Pilote pilot) {
		totalPilotes.remove(pilot);
		
	}

	@Override
	public List<Aircraft> getAircrafts() {
		return fleet;
	}


	@Override
	public List<Flight> getFlights() {
		return flightList;
	}

	@Override
	public List<Flight> getFlights(int minPrice, int maxPrice) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flightList) {
				if(f.price>=minPrice&&f.price<=maxPrice)
					fli.add(f);
		}
		return fli;
	}

	@Override
	public List<Flight> getFlights(Date DepartureTime, String DepartureAirport) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flightList) {
				if(f.departureDateTime.equals(DepartureTime)&&f.departureAirport.equals(DepartureAirport))
					fli.add(f);
		}
		return fli;
	}

	@Override
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

	@Override
	public List<Flight> getFlights(int availableSeats) {
		List<Flight> fli=new ArrayList<Flight>();
		for(Flight f:flightList) {
			if(f.availablesSeats>=availableSeats) {
				fli.add(f);
			}
		}
		return fli;
	}

	@Override
	public void addFlight(Flight flight) {
		flightList.add(flight);
		
	}

	@Override
	public void deleteFlight(Flight flight) {
		flightList.remove(flight);
		
	}

	@Override
	public int getPilotId(Pilote pilot) {
		return pilot.id;
	}

	@Override
	public String getTailNumber(Aircraft aircraft) {
		return aircraft.tailNumber;
	}

	@Override
	public void addAircraft(Aircraft aircraft) {
		fleet.add(aircraft);
		
	}

	@Override
	public void removeAircraft(Aircraft aircraft) {
		fleet.remove(aircraft);
		
	}

	@Override
	public Pilote getPilot(Flight flight) {
		return flight.pilot;
	}

	@Override
	public double getPrice(Flight flight) {
		return flight.price;
	}

	@Override
	public int getAvailableSeats(Flight flight) {
		return flight.availablesSeats;
	}

}
