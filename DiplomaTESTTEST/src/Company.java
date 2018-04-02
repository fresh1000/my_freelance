import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public abstract class Company {
	protected ArrayList<String> date = new ArrayList<String>();
	protected ArrayList<Double> price = new ArrayList<Double>();
	protected ArrayList<Double> profit = new ArrayList<Double>();
	protected ArrayList<Double> minus = new ArrayList<Double>();
	protected double allProfit;
	protected double allMinus;
	protected static double constValue = 10000;


	abstract public void addDate();

	public ArrayList<Double> getMinus() {
		return minus;
	}

	public void setMinus(ArrayList<Double> minus) {
		this.minus = minus;
	}

	public void addProfit() {
		Collections.reverse(price);
		int numShares = (int) (constValue / price.get(0));
		double sumStart = numShares * price.get(0);
		for (int i = 0; i < price.size() - 1; i++) {
			double currentSum = numShares * price.get(i);
			if (sumStart * 1.05 < currentSum && numShares > 1) {
				double plus = currentSum - sumStart;
				numShares -= (int) (plus / price.get(i));
				sumStart = numShares * price.get(i);
				profit.add(plus);
				allProfit += plus;
				//System.out.println(sumStart);
			} else if (sumStart * 0.95 > currentSum) {
				double min = sumStart - currentSum;
				numShares += min / price.get(i);
				sumStart = numShares * price.get(i);
				profit.add((-1) * min);
				allMinus += min;
				//System.out.println(sumStart);
			} else {
				profit.add(0.0);
			}
		}
		Collections.reverse(profit);
		Collections.reverse(price);
		//System.out.println(profit);
	}

	public ArrayList<Double> getProfit() {
		return profit;
	}

	public void setProfit(ArrayList<Double> profit) {
		this.profit = profit;
	}

	abstract public void addPrice();

	public ArrayList<String> getDate() {
		return date;
	}

	public ArrayList<Double> getPrice() {
		return price;
	}

	public void setDate(ArrayList<String> date) {
		this.date = date;
	}

	public void setPrice(ArrayList<Double> price) {
		this.price = price;
	}

}
