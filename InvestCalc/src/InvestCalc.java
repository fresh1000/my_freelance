
public class InvestCalc {
	private int years;
	private double investAmount;
	private double annualRate;
	
	public InvestCalc(int years, double investAmount, double annualRate) {
		this.years = years;
		this.investAmount = investAmount;
		this.annualRate = annualRate;
	}

	public double calcFutureValue() {
		double value;
		value = investAmount * Math.pow((1 + (annualRate / 100) / 12), years * 12);
		return value;
	}
	
	public int getYears() {
		return years;
	}

	public double getInvestAmount() {
		return investAmount;
	}

	public double getAnnualRate() {
		return annualRate;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public void setInvestAmount(double investAmount) {
		this.investAmount = investAmount;
	}

	public void setAnnualRate(double annualRate) {
		this.annualRate = annualRate;
	}
	
	
	
}
