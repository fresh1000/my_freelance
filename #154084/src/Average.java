import java.util.Arrays;
import java.util.Scanner;

public class Average {
	private int[] data;
	private double mean;

	public Average() {
		this.data = new int[5];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < data.length; i++) {
			System.out.println("score number " + (i + 1) + ":");
			int number = sc.nextInt();
			data[i] = number;
		}
		
		calculateMean();
		selectionSort();
		toString();

	}

	public void calculateMean() {
		double sum = 0;
		for (int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		
		mean = sum / data.length;
	}

	public void selectionSort() {
		int current;
		int prev;
		for(int i = 1; i < data.length; i++){
	        current = data[i];
	        prev = i - 1;
	        while(prev >= 0 && data[prev] < current){
	            data[prev+1] = data[prev];
	            prev--;
	        }
	        data[prev+1] = current;
		}
	}

	public String toString() {
		return "Average [data=" + Arrays.toString(data) + ", mean=" + mean + "]";
	}
}
