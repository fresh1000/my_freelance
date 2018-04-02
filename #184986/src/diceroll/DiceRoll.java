package diceroll;
/**
*
* @author syed0023
*/
import java.util.Random;

public class DiceRoll {

	public static void main(String[] args) {
		int size = 13;
		int dicerolling = 36000000;
		
		int[] sum = new int[size];
		
		for (int i = 0; i < size; i++) {
			sum[i] = 0;
		}
		
		Random random = new Random();
		int dice1;
		int dice2;
		
		for (int i = 1; i <= dicerolling; i++) {
			dice1 = random.nextInt(6) + 1;
			dice2 = random.nextInt(6) + 1;
			//System.out.printf("%s%8s%8s%8s%n", "Sum", "Total", "Predict", "outcome");
			sum[dice1+dice2]++;
		}
		
		for (int i = 2; i < size; i++) {
			System.out.printf("Sum two dice %d total: %d\n", i, sum[i]);
		}
	}

}
