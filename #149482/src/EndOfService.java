
public class EndOfService extends Event {
	
	public void print() {
		System.out.println("EndOfService Event at time " + timeOfEvent);
	}
	
	public String toString() {
		return "EndOfService:" + timeOfEvent + "; ";
	}
}
