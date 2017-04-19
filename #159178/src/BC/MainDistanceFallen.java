package BC;

public class MainDistanceFallen {
	public static double distance(int seconds) {
		double distance;
		distance = seconds * seconds * 9.8 / 2;
		return distance;
	}

	public static void main(String[] args) {
		int seconds = 10;
		System.out.println(distance(seconds));
	}
}
