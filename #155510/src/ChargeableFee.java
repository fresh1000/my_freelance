
public class ChargeableFee extends Account {

	public ChargeableFee(double initialBalance) {
		super(initialBalance);
	}
	
	public void endMonth() {
		currentBalance = currentBalance - (counterWithdraw  * 0.5);
		System.out.println("Current balance end of Month: " + currentBalance);
	}
	
}
