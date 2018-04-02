
public class TMA02Q1a {

	public static void main(String[] args) {
		int from = 1;
		int to = 3;
		int sum = 0;

		for (int i=from; i<=to; i++) {
			int row = (int) Math.pow(2, i);
			sum += row;
			System.out.println(sum);
		}

		System.out.println("The sum is "+sum);

	}

}
