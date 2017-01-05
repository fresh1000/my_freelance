
public class Test {

	public static void main(String[] args) {
		SavingsAccount save = new SavingsAccount("ASD");
		save.deposit(90);
		System.out.println(save.toString());
		save.withdraw(10);
		System.out.println(save.toString());
		save.processEndOfMonth();
		save.processEndOfMonth();
		System.out.println(save.toString());
		
		CheckingAccount check = new CheckingAccount("ASD");
		System.out.println();
		check.enableOverdraft(save);
		check.deposit(5);
		System.out.println(check.toString());
		check.withdraw(20);
		System.out.println(check.toString());
		System.out.println(save.toString());
		
	}

}
