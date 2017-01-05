
public class Event implements Comparable<Event> {
	
	public double timeOfEvent;
	
	public int compareTo(Event e) {
		return new Double(timeOfEvent).compareTo(new Double(e.timeOfEvent));
	}
	
}
