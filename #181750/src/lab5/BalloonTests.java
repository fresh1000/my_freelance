package lab5;
import balloon.Balloon;

public class BalloonTests {

	public static void main(String[] args) {
		Balloon balloon = new Balloon(10);//create balloon with max radius 10

		System.out.println("Start radius must be 0 and result: " + balloon.getRadius());
		System.out.println("Ballon isPopped must return false and result: " + balloon.isPopped());
		
		balloon.blow(5);//blow Balloon to 5
		balloon.deflate();//deflate Balloon
		balloon.blow(5);//blow Balloon to 5
		balloon.blow(5);//blow Balloon to 5
		
		System.out.println("If current radius not more max radius must return false and return: " + balloon.isPopped());
		System.out.println("Current radius: " + balloon.getRadius());
		
		balloon.blow(5);//now Balloon must popped and radius equals 0
		
		System.out.println("Now Ballon must popped and result: " + balloon.isPopped());
		System.out.println("Radius must be equals 0 and result: " + balloon.getRadius());
		
	}

}
