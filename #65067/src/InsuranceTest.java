import java.util.Scanner;

public class InsuranceTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int currentYear,birthClient;
		
		System.out.print("Enter current year: ");
		currentYear = sc.nextInt();
		System.out.print("Enter client bith year: ");
		birthClient = sc.nextInt();
		
		Insurance client = new Insurance(birthClient,currentYear);
		client.calcPremiumAmount();//calculate premium amount
		System.out.println("Premium amount: $" + client.getPremiumAmount());//return premium amount
	}

}
