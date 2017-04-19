import java.util.ArrayList;
import java.util.Arrays;

public class Flight {
	private Airline airline;
	private String flightId; 
	private Airport originAirport;
	private Airport destinationAirport;
	private Seat[] seats;
	
	public Flight(Airline airline, String flightId, Airport originAirport, Airport destinationAirport) {
		this.airline = airline;
		this.flightId = flightId;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
	}

	public Airline getAirline() {
		return airline;
	}

	public String getFlightId() {
		return flightId;
	}

	public Airport getOriginAirport() {
		return originAirport;
	}

	public Airport getDestinationAirport() {
		return destinationAirport;
	}


	public Seat[] getSeats() {
		return seats;
	}

	public void setSeats(Seat[] seats) {
		this.seats = seats;
	}

	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}

	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}

	public String toString() {
		return "Flight: Airline=" + airline + ", FlightId=" + flightId + ", Origin airport=" + originAirport
				+ ", Destination airport=" + destinationAirport + ", Seats=" + Arrays.deepToString(seats) + "\n\n";
	}

	
	
	
	
}
