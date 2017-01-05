
public class FixedFee extends Account {

	public FixedFee(double initialBalance) {
		super(initialBalance);
	}
	public void endMonth() {
		currentBalance = currentBalance - 5;
		System.out.println("Current balance end of Month: " + currentBalance);
	}

}
