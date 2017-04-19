
public class Client {
	public static void main(String[] args) {
		SystemManager manager = new SystemManager();
		// create airports
		manager.createAirport("YHZ");
		manager.createAirport("YYZ");
		manager.createAirport("YUL");
		manager.createAirport("YVR");
		manager.createAirport("YYC");
		manager.createAirport("CHELSEA"); // invalid
		manager.createAirport("122423"); // invalid
		manager.createAirport("YEG");
		manager.createAirport("BOS");
		manager.createAirport("JFK");
		System.out.println();
		
		// create airlines
		manager.createAirline("AC");
		manager.createAirline("DELTA");
		manager.createAirline("USAIR");
		manager.createAirline("WSJET");
		manager.createAirline("GETASDS"); // invalid

		// create flights
		System.out.println();
		manager.createFlight("AC", "YHZ", "YUL", "123");
		manager.createFlight("AC", "YHZ", "YYZ", "567");
		manager.createFlight("AC", "YUL", "YHZ", "789");
		manager.createFlight("AC", "YUL", "YVR", "123");// invalid –AC cannot have two flights with same id.
		manager.createFlight("AC", "YHZ", "YYZ", "689");
		manager.createFlight("DELTA", "YHZ", "BOS", "123");
		
		// create seats
		System.out.println();
		manager.createSeats("AC", "123", 40);
		manager.createSeats("DELTA", "123", 25);
		System.out.println();
		
		// find available flights
		manager.findAvailableFlights("YHZ", "YYZ");
		System.out.println();
		
		//// book seats
		manager.bookSeat("AC", "123", 1, 'A');
		manager.bookSeat("AC", "123", 20, 'F');
		manager.bookSeat("AC", "987", 2, 'B');// invalid – 987 not created
		manager.bookSeat("AC", "123", 90, 'C');// invalid –row 90 doesn’t exist
		//display system details
		manager.displaySystemDetails();
	}
}