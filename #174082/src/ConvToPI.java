
public class ConvToPI {

	public static void main(String[] args) {
		double aN = 0;
		int n = 10000;// n = 10^4
		for (int i = 0; i < n; i++) {
			aN +=4 * Math.pow(-1, i)/(2*i + 1);//calculates
		}
		System.out.println("For n = 10^4 : " + aN);//print result
		
		aN = 0;
		n = 1000000;//for n = 10^6
		for (int i = 0; i < n; i++) {
			aN += 4 * Math.pow(-1, i)/(2*i + 1);//calculates
		}
		System.out.println("For n = 10^6 : " + aN);//print result
		
		aN = 0;
		n = 100000000;//for n = 10^8
		for (int i = 0; i < n; i++) {
			aN += 4 * Math.pow(-1, i)/(2*i + 1);//calculates
		}
		System.out.println("For n = 10^8 : " + aN);//print result
		
	}

}
