/*The mortgage calculator program will do the following: 
 * This program implements the mortgage calculation.
 */
package alexmortgagecalculator4;

/**
 *
 * @author Linu Alex
 * @version 1.0, java Assn 5
 */
import java.util.Scanner ;

public class AlexMortgageCalculator5 {
   
    public static void main(String[] args) {
        
        Scanner keyboardIn = new Scanner (System.in);
        System.out.print("Please enter the home buyer’s last name: ");
        String LastName = keyboardIn.nextLine();
        
        System.out.print("Please enter the home value: ");
        Double homeValue = keyboardIn.nextDouble();
        System.out.println("\n");
        
        System.out.println("Down Payment Options:\n N - Nothing down\n L - Low down payment\n "
        		+ "S - Standard down payment\n H - High down payment\n Please enter your choice:");
        char options = keyboardIn.next().charAt(0);

        MortgageLoan loan1 = new MortgageLoan(LastName, homeValue, options, 20);
        MortgageLoan loan2 = new MortgageLoan(LastName, homeValue, options, 30);
        
        loan1.displayLoanInfo();
        System.out.println("\n");
        System.out.println("Loan Option 1:");
        loan1.calcAndDisplayPaymentInfo();
        System.out.println("\n");
        System.out.println("Loan Option 2:");
        loan2.calcAndDisplayPaymentInfo();
         
    }
     /**
     * Describe what the program does.
     */
    public static void describe() {
        System.out.println("This program implements a Mortgage Payment Calculator");
        System.out.println("Given a home's purchase price and loan'ss annual interest rate,");
        System.out.println("it will compute the monthly mortgage payment, which includes");
        System.out.println("taxes, insurance, principle and interest.\n");
    }
    
  
}


