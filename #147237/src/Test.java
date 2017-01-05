import java.lang.reflect.Array;
import java.util.*;

public class Test {

	public static void PrefixAverages1(double x[], int n) {// first algo with parametr x[] and n 
		double s;// create variable s
		double a[] = new double [n];//initialization array(answer)
		for (int i = 0; i < n; i++){//loop from i=0 to n-1
			s = x[0];//s assign first element of array in main  
			for (int j = 1; j < n; j++){//loop from j=1 to n-1
				if (j <= i){//if j<=i do 
					s = s + x[j];//s assign s plus j-element of array in main 
				}
			}
			a[i] = s / (i + 1);//i-element array (answer) assign s div (i + 1)
		}
	}
	
	public static void PrefixAverages2(double x[], int n) {// first algo with parametr x[] and n
		double a[] = new double [n];//initialization array(answer)
		double s = 0;//create variable s and assigh 0
		for (int i = 0; i < n; i++){//loop from i=0 to n-1
			s = s + x[i];//s assign s plus i-element of array in main
			a[i] = s / (i + 1);//i-element array (answer) assign s div (i + 1)
		}
		
	}
	
	public static void main(String[] args) {
		int n = 10000; // leight array
		double a[] = new double [n]; // initialization array(main)
		for (int i = 0; i < n; i++)//loop from i=0 to n-1
			a[i] = Math.random()*100000; // random filling array
		long timeout = System.currentTimeMillis(); //start clock
		PrefixAverages1(a, n); //call algo 1
		timeout = System.currentTimeMillis() - timeout; // result time 
		System.out.println();//print empty line
		long timeout2 = System.currentTimeMillis();//start clock2
		PrefixAverages2(a, n); //call algo 2
		timeout2 = System.currentTimeMillis() - timeout2; // result time2
		System.out.println("Time 1: ");//print 
		System.out.printf(Locale.US, "%.9fs\n", (double) timeout/1000); // print time running in sec 
		
		System.out.printf(Locale.US, "%.9fs\n", (double) timeout2/1000); // print time2 running in sec 
	}

}

