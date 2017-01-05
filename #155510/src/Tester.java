
public class Tester {
	public static void main(String[] args) {
		ChargeableFee a = new ChargeableFee(100);
		a.deposit(20);
		a.withdraw(50);
		a.withdraw(5);
		a.withdraw(5);
		a.endMonth();
		
		FixedFee b = new FixedFee(1000);
		b.deposit(1000);
		b.withdraw(100);
		b.withdraw(10);
		b.withdraw(100);
		b.endMonth();
	}
}
