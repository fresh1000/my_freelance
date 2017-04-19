import java.util.ArrayList;

public class SystemManager {
	private ArrayList<Airport> airports = new ArrayList<>();
	private ArrayList<Airline> airlines = new ArrayList<>();
	private ArrayList<Flight> flights = new ArrayList<>();

	public void createAirport(String n) {
		if ((n.length() <= 3) && (n.matches("(?i).*[a-z].*"))) {//regex for airport name
			boolean sameName = false;//boolean for check same name airport
			for (int i = 0; i < airports.size(); i++) {
				if (airports.get(i).getName().equals(n)) {//if found in ArrayList set same name to true
					sameName = true;
				}
			}
			if (!sameName) {//if same name false add to ArrayList airport
				airports.add(new Airport(n));
				System.out.println("Airport " + n + " was created");
			} else
				System.out.println("Invalid");
		} else {
			System.out.println("Invalid");
		}
	}

	public void createAirline(String n) {
		if (n.matches("(?i).*[a-z].*") && n.length() <= 6) {//regex for airline name
			boolean sameName = false;//boolean for check same name airline
			for (int i = 0; i < airlines.size(); i++) {
				if (airlines.get(i).getAirlineID().equals(n)) {//if found in ArrayList set same name to true
					sameName = true;
				}
			}
			if (!sameName) {//if same name false add to ArrayList airline
				airlines.add(new Airline(n));
				System.out.println("Airline " + n + " was created");
			} else
				System.out.println("Invalid");
		} else
			System.out.println("Invalid");
	}

	public void createFlight(String aname, String orig, String dest, String id) {

		Airline airId = new Airline(aname);//create airline
		Airport origin = new Airport(orig);// create airport origin
		Airport des = new Airport(dest);//create airport destination

		boolean sameName = false;//boolean for check same name flight
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getFlightId().equals(id) && flights.get(i).getAirline().getAirlineID().equals(aname)) {
				sameName = true;//if found flight with name "id" and airline with name "aname" in ArrayList set same name to true
			}
		}

		if (!sameName) {//if same name false add to ArrayList flight
			flights.add(new Flight(airId, id, origin, des));
			System.out.println("Flight " + id + " was creaated");
		} else
			System.out.println("Ivalid");
	}

	public void createSeats(String air, String flID, int rows) {
		boolean found = false;//check found flight and airline
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getFlightId().equals(flID) && flights.get(i).getAirline().getAirlineID().equals(air)) {
				found = true;//if find set to true and set rows in Flight seats
				flights.get(i).setSeats(new Seat[rows]);
				System.out.println(rows + " seat in flight " + flID +" with airlines " + air + " was created");
			}
		}
		if (!found) {
			System.out.println("Invalid");
		}
	}

	public void findAvailableFlights(String origin, String dest) {
		boolean foundFlights = false;//check find flight 
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getOriginAirport().getName().equals(origin)
					&& flights.get(i).getDestinationAirport().getName().equals(dest)) {//if flight found set found flights to true
				System.out.println("Flight:" + flights.get(i).getFlightId());//print founds flights
				foundFlights = true;
			}
		}
		if (!foundFlights) {
			System.out.println("Not found");
		}
	}

	public void bookSeat(String air, String fl, int row, char col) {
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).getAirline().getAirlineID().equals(air) && flights.get(i).getFlightId().equals(fl) &&
					flights.get(i).getSeats().length > row) {//if found flight and airline in ArrayList and row in flight less max rows
				System.out.println("Seat " + row + col + " was created");//created seat
				Seat[] seats = flights.get(i).getSeats();
				Seat seat = new Seat(row, col);
				seats[row] = seat;
				flights.get(i).setSeats(seats);
			}
		}

	}

	public void displaySystemDetails() {
		System.out.println();
		System.out.println(airlines.toString());//print all list airlines
		System.out.println();
		System.out.println(airports.toString());//print all list airports
		System.out.println();
		System.out.println(flights.toString());//print all information for flights
		
	}

}
