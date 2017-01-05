/**
 *
 * @author 
 * @version 1.0, Java Project 5: Fractions
 */
public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction() {

	}

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		if (denominator == 0) {
			System.out.println("Error: Invalid denominator!!");
			System.exit(0);
		}
		this.denominator = denominator;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public double toDecimal() {
		double decimal = (double) numerator / denominator;
		return decimal;
	}

	public String toString() {
		return numerator + "/" + denominator;
	}

	public void reduce() {
		for (int i = numerator * denominator; i > 1; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				denominator = denominator / i;
				numerator = numerator / i;
			}
		}
	}

}
