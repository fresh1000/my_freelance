package DEFG;

public class MainDEFG {
	//d)
	public static float geometricSeries(int a0, int r, int n) {
		float sum = 0;
		sum = (float) (a0 *(Math.pow(r, n) - 1)/(r-1));
		return sum;
	}
	//e)
	public static boolean isDivible(int a, int b) {
		if(a % b == 0)
			return true;
		else 
			return false;
	}
	//f)
	public static int smallest(int number) {
		int min = number;
		for(int i = 2; i < number; i++){
			if(number % i == 0) {
				min = i;
				return min;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		System.out.println("Sum geometric series: "+ geometricSeries(2, 5, 10));
		System.out.println(isDivible(12, 5));
		System.out.println(smallest(15));
	}
}
