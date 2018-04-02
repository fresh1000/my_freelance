package lab6;

public class Basketball {
	private double diameter;
	private boolean intflatedStatus;
	
	public Basketball(double givenDiameter) {
		this.diameter = givenDiameter;
		this.intflatedStatus = false;
	}

	public boolean isDribbleable() {
		if (this.intflatedStatus) {
			return true;
		}else
			return false;
	}

	public double getDiameter() {
		return this.diameter;
	}

	public double getCircumference() {
		return this.diameter * Math.PI;
	}

	public void inflate() {
		this.intflatedStatus = true;
	}
}
