import java.util.Scanner;

public class Application {

	static void fixedFee() {
		Scanner sc = new Scanner(System.in);
		double initialBalance;
		double amount;
		boolean exit = false;
		System.out.print("Enter initial balance: ");
		initialBalance = sc.nextDouble();
		FixedFee fixed = new FixedFee(initialBalance);
		System.out.println("Account FixedFee created");
		while(!exit) {
			int option;
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.End of month");
			System.out.println("4.Exit");
			System.out.print("Enter option:");
			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Deposit");
				System.out.print("Enter amount:");
				amount = sc.nextDouble();
				fixed.deposit(amount);
				break;
			case 2:
				System.out.println("Withdraw");
				System.out.print("Enter amount:");
				amount = sc.nextDouble();
				fixed.withdraw(amount);
				break;
			case 3:
				System.out.println("End of month");
				fixed.endMonth();
				break;
			case 4:
				exit = true;
				break;
			default:
				break;
			}
		}

	}
	
	static void chargeableFee() {
		Scanner sc = new Scanner(System.in);
		double initialBalance;
		double amount;
		boolean exit = false;
		System.out.print("Enter initial balance: ");
		initialBalance = sc.nextDouble();
		ChargeableFee chargeable = new ChargeableFee(initialBalance);
		System.out.println("Account ChargeableFee created");
		while(!exit) {
			int option;
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.End of month");
			System.out.println("4.Exit");
			System.out.print("Enter option:");
			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Deposit");
				System.out.print("Enter amount:");
				amount = sc.nextDouble();
				chargeable.deposit(amount);
				break;
			case 2:
				System.out.println("Withdraw");
				System.out.print("Enter amount:");
				amount = sc.nextDouble();
				chargeable.withdraw(amount);
				break;
			case 3:
				System.out.println("End of month");
				chargeable.endMonth();
				break;
			case 4:
				exit = true;
				break;
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1.Create FixedFee account");
			System.out.println("2.Create ChargeableFee account");
			System.out.print("Enter your choice:");
			choice = sc.nextInt();
			if ((choice < 1) && (choice > 2)) {
				System.out.println("Invalid choice!");
			}
		} while ((choice < 1) && (choice > 2));

		if (choice == 1) {
			fixedFee();
		}else
		chargeableFee();

	}

}
