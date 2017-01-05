
public class CheckingAccount extends BankAccount {
	private boolean overdraft;
	SavingsAccount overdraftAccount;
	
	
	public CheckingAccount(String number) {
		super(number);
		this.type = 2;
		this.overdraft = false;
	}
	
	public void enableOverdraft(SavingsAccount account) {
		overdraft = true;
		this.overdraftAccount = account;
		System.out.println("Overdraft protection is enabled");
	}
	
	public void disableOverdraft() {
		overdraft = false;
		this.overdraftAccount = null;
		System.out.println("Overdraft protection is disabled");
	}
	
	public void withdraw(double amount) {
		super.withdraw(amount);
		if(this.balance < amount && overdraft == true){	    	
		    	overdraftAccount.balance = overdraftAccount.balance - Math.abs(balance) - 2;
		    	balance = balance + Math.abs(balance);
		}
		if(this.balance < amount && overdraft == false) {
			balance = balance + amount;
			System.out.println("Not enough funds");
		}
	}	
}
