
public class MaxPositive {

	public static void main(String[] args) {
		boolean found = false;//variable for check if statement in loop
		int maxPositive = 0;
		for (int i = 1000; i > 0; i--) {
			if (i % 3 == 2 && i % 5 == 3 && i % 11 == 9 && !found) {
				maxPositive = i;
				found = true;
			}
		}
		System.out.println("Max positive: " + maxPositive);
	}

}
