/*The mortgage calculator program will do the following: 
 * This program implements the mortgage calculation.
 */
package alexmortgagecalculator4;

/**
 *
 * @author Linu Alex
 * @version 1.0, java Assn 5
 */


public class MortgageLoan {
	private String loanIdentifier;
	private double homeValue;
	private double downPayment;
	private double loanAmount;
    private int length;
    private double annualInterestRate;
    private char loanType;
    
    public MortgageLoan() {
    	loanIdentifier = "";
    	loanAmount = 0.0;
    	annualInterestRate = 0.0;
    	homeValue = 0.0;
    	downPayment = 10.0;
    	length = 30;    			
    }
    
	public MortgageLoan(String loanIdentifier, double homeValue, char downPayment, int length) {
		this.homeValue = homeValue;
		this.length = length;
		setLoanIdentifier(loanIdentifier);
		setDownPayement(downPayment);
		setLoanAmount();
		setLoanType();
		setAnnualInterestRate();
	}

	public String getLoanIdentifier() {
		return loanIdentifier;
	}
	
	public void setLoanIdentifier(String LastName) {
		final int LENGTH_IDENTIFIER = 6;
		final String SECOND_STRING = "XXXXXX";
		if(LastName.length() < LENGTH_IDENTIFIER) {
			LastName = LastName + SECOND_STRING;
		}
		String first =  LastName.substring(0, 6).toUpperCase();
		loanIdentifier = first; 
	}
	
	public double getHomeValue() {
		return homeValue;
	}
	
	public int getLength(){
		return length;
	}
	
	public void setHomeValue(double homeValue) {
		this.homeValue = homeValue;
	}
	
    public void setLoanAmount(){
    	loanAmount = homeValue - (homeValue * downPayment);
    }
    
    public double getLoanAmount(){
    	return loanAmount;
    }
    
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	  
	public void setDownPayement(char choiceDownPayment) {
		switch(choiceDownPayment){
		case 'N':
			this.downPayment = 0.0;
			break;
		case 'L':
			this.downPayment = 0.10;
			break;
		case 'S':
			this.downPayment = 0.20;
			break;
		case 'H':
			this.downPayment = 0.30;
			break;
		default:
			System.out.println("You choice was invalid, no down payment will be applied.");
			this.downPayment = 0.0;
			break;
		}
	}
	
	public void setAnnualInterestRate() {
		if(loanType == 'C') {
			if(length == 20) {
				this.annualInterestRate = 0.03850;
			}
			if(length == 30) {
				this.annualInterestRate = 0.04500;
			}
		}
		if(loanType == 'J') {
			if(length == 20){
				this.annualInterestRate = 0.03500;
			}
			if(length == 30) {
				this.annualInterestRate = 0.04125;
			}
		}
	}
	
	public void setLoanType() {
		final double UPPER_LIMIT = 417000.0;
		if(homeValue < UPPER_LIMIT) {
			this.loanType = 'C';
		}else
			this.loanType = 'J';
	}
	
	public double calcPrincipleAndInterest() {
		    double factor = Math.exp(length*12 * Math.log(1 + annualInterestRate / 12));
	        double monthly = factor * annualInterestRate / 12 * loanAmount / (factor - 1);
	        return monthly;
	}
	
	public  double calcInsurance() {	     
	    double rate;
	    double monthly = 0;
		if(downPayment <= 0.10){
			rate = 0.0052;
			monthly = (homeValue * rate) / 12;
		}
		if(downPayment > 0.10 && downPayment <= 0.20) {
			rate = 0.0049;
			monthly = (homeValue * rate) / 12;
		}
		if(downPayment > 0.20){
			rate = 0.0047;
			monthly = (homeValue * rate) / 12;
		}

		return Math.round(monthly);
	}

	public  double calcPropertyTax() {
       final double ASSESS_VALUE_RATIO = 0.85;
       final double PROERTY_TAX_RATIO = 0.0063;
       final double ADMIN_FEE = 35;
       double total =
    		   homeValue * ASSESS_VALUE_RATIO * PROERTY_TAX_RATIO + ADMIN_FEE;
       return total / 12;
	}
	
	public void displayLoanInfo() {
		String type = "";
		if(loanType == 'C') {
			type = "conforming";
		}else
			type = "jumbo";
		System.out.printf("Loan identifier                     %s\n", getLoanIdentifier());
		System.out.printf("Loan amount                         %8.2f\n", getHomeValue());
		System.out.printf("Loan type                           %s\n", type);
	}
	
	public void calcAndDisplayPaymentInfo() {
		System.out.println("  Loan length                      " + getLength() + " years");
    	System.out.printf("  Annual interest rate            %8.3f%%\n", getAnnualInterestRate() * 100);
        System.out.printf("\n  Monthly Taxes                    %8.2f\n", calcPropertyTax());
        System.out.printf("  Monthly Inssurance               %8.2f\n", calcInsurance());
        System.out.printf("  Monthly Principle & Interest     %8.2f\n", calcPrincipleAndInterest());
        System.out.println("                                 ----------");
        System.out.printf("  Total Monthly Mortgage Payment   %8.2f\n", calcPropertyTax() +
        		calcInsurance() + calcPrincipleAndInterest());
	}
}

