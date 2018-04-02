import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		Wallet wallet = new Wallet(1246);
		while (true) {
			System.out.println("Choose action");
			System.out.println("0 Exit");
			System.out.println("1 Print all information about Wallet.");
			System.out.println("2 Add a Credit Card.");
			System.out.println("3 Add a Debit Card.");
			System.out.println("4 Add an ID Card.");
			System.out.println("5 Add Cash.");
			System.out.println("6 Make a purchase");
			Scanner scan = new Scanner(System.in);
			int n = 0;
			try {
				n = scan.nextInt();
			} catch (Exception e) {
				System.out.println("Be careful with input");
				n = -1;
			}
			switch (n) {
			case 0:
				System.exit(0);
				break;
			case 1:
				System.out.println(wallet.toString());
				break;
			case 2:
				wallet.addCreditCard();
				break;
			case 3:
				wallet.addDebitCard();
				break;
			case 4:
				System.out.print("Enter card ID:");
				String cardID = scan.nextLine();
				wallet.addCardID(cardID);
				break;
			case 5:
				System.out.print("Enter add cash: ");
				double cash = scan.nextDouble();
				wallet.addCash(cash);
				break;
			case 6:
				System.out.println("Print purchase amount: ");
				double pay=scan.nextDouble();
				wallet.purchase(pay);
				break;
			default:
				System.out.println("Please print correct number");
			}

		}

	}

}
