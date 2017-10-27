import java.util.Locale;
import java.util.Scanner;
/**
 * 
 * @author
 *	ID:140017S
 *	Description:Program to calculate how much to pay casual employees who are paid
 *  on an hourly basis. The Australian Department of Employment stipulates that employees should be
 *  paid time and a half for any hours over 40 that they work in a single week.
 */
public class MIT140017SLogicFoo {

	public static void main(String[] args) {
		//scanner for read from console
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		//all double variables
		double basePay, grossPay, netPay, payAsGain, overtimePay, rateBase, rateOvertime;
		//all integer variables
		int workedHours, overtime;
		//string for employee name
		String employee = null;

		System.out.println("Enter employee name:");
		employee = sc.nextLine();//read employee name

		boolean inputWorkedHours = true;//boolean variable for exit from loop
		do {
			System.out.println("Enter hours worked:");
			workedHours = sc.nextInt();//read hours worked
			if (workedHours > 60) {
				System.out.println("Error, hours worked must be less then 60. Try again!");
			} else {
				inputWorkedHours = false;//exit loop
			}
		} while (inputWorkedHours);

		boolean inputBasePay = true;//boolean variable for exit from loop
		do {
			System.out.println("Enter base pay:");
			basePay = sc.nextDouble();//read base pay
			if (basePay < 18) {
				System.out.println("Error, base pay must be greater then 18. Try again!");
			} else {
				inputBasePay = false;//exit loop
			}
		} while (inputBasePay);
		
		if (workedHours > 40) {
			overtime = workedHours - 40;
			overtimePay = 1.5 * basePay;
			rateBase = basePay * 40;
			rateOvertime = overtimePay * overtime;
			grossPay = rateBase + rateOvertime;
		} else {
			overtime = 0;
			overtimePay = 0;
			grossPay = workedHours * basePay;
			rateBase = grossPay;
			rateOvertime = 0;
		}

		payAsGain = 0.15 * grossPay;
		netPay = grossPay - payAsGain;
		
		//print all information
		System.out.printf("\n%-50s%s\n\n", "LogicFoo Ltd", "ABN:55135151115133");
		System.out.printf("%-13s%-37s%s\n\n", "Pay Slip for:", employee, "Payment Date: 25/80/2017");
		System.out.printf("%-50s%s%.2f\n", "Pay Period from: 14/08/2017 to 23/08/2017", "Gross Pay:$", grossPay);
		System.out.printf("%59s%.2f\n\n", "Net Pay:$", netPay);
		System.out.printf("%-25s%-25s%-25s%-10s\n", "Description", "Hours Worked", "Calculated Rate", "Type");
		System.out.println("_______________________________________________________________________________");
		System.out.printf("%-15s%-10.2f%-25d%s%-24.2f%-25s\n", "Base Hourly @$", basePay, workedHours - overtime, "$",
				rateBase, "Wages");
		System.out.printf("%-11s%-14.2f%-25d%s%-24.2f%-25s\n", "Overtime @$", overtimePay, overtime, "$", rateOvertime,
				"Wages");
		System.out.printf("%-50s%s%-23.2f%-25s\n", "PAYG Withholding", "$-", payAsGain, "Tax");

	}

}
