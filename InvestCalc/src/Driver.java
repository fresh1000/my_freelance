import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Driver {

	public static void main(String[] args) {
		
		InvestCalc calc = new InvestCalc(2, 10000, 5.75);
		NumberFormat formatter = new DecimalFormat("#0.00");
		System.out.println(formatter.format(calc.calcFutureValue()));

	}

}
