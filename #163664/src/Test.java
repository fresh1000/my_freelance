
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] temperatures;
		temperatures= new double[95];
		double average;
		double sum = 0;
		for(int i = 0; i < temperatures.length; i++) {
			sum = sum + temperatures[i]; 
		}
		average = sum/temperatures.length;
	}

}
