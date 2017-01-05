import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
	
	public int fact(int n){

		return n*fact(n-1);

		  }

	
	static public void main(String args[]){

		Scanner scanner = new Scanner(System.in); int userIn=0;
		try {
		System.out.println("Enter a number:");
		userIn = scanner.nextInt();
		}catch(InputMismatchException e){
		userIn=-1;
		}
		finally{
		userIn++;
		}
		System.out.println("Output is: "+userIn);
		}


}
