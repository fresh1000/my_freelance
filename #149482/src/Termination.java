
public class Termination extends Event{
	
	public void print() {
		System.out.println("Termination Event at time " + timeOfEvent);
	}
	
	public String toString() {
		return "Termination:" + timeOfEvent + "; ";
	}
	
}
