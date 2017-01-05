
public class Arrival extends Event {
	
	public void print() {
		System.out.println("Arrival Event at time " + timeOfEvent);
	}
	
	public String toString() {
		return "Arrival:" + timeOfEvent + "; ";
	}
}
