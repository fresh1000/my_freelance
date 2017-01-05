
public class TunnelTollCharge {
	private int numberOfWheels;
	private int length;
	private int numberOfAxles;
	private double weight;
	private double costWeekday;
	private int classVechicle;
	private String typeVechicle;
	private boolean isWeekday;
	
	public TunnelTollCharge(int numberOfWheels, boolean isWeekday) {
		this.numberOfWheels = numberOfWheels;
		this.isWeekday = isWeekday;
	}

	
	
	public TunnelTollCharge(int numberOfWheels, int length, int numberOfAxles, boolean isWeekday) {
		this.numberOfWheels = numberOfWheels;
		this.length = length;
		this.numberOfAxles = numberOfAxles;
		this.isWeekday = isWeekday;
	}



	public TunnelTollCharge(int numberOfWheels, int length, int numberOfAxles, double weight, boolean isWeekday) {
		this.numberOfWheels = numberOfWheels;
		this.length = length;
		this.numberOfAxles = numberOfAxles;
		this.weight = weight;
		this.isWeekday = isWeekday;
	}

	public boolean isWeekday() {
		return isWeekday;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public int getLength() {
		return length;
	}

	public int getNumberOfAxles() {
		return numberOfAxles;
	}

	public double getWeight() {
		return weight;
	}

	public int getClassVechicle() {
		return classVechicle;
	}
	
	public String getTypeVechicle() {
		return typeVechicle;
	}

	public double getCostWeekday() {
		return costWeekday;
	}

	public void typeVechicle() {
		if(numberOfWheels < 4) {
			classVechicle = 1;
			typeVechicle = "Motorbike";
			costWeekday = 2.0;
		}
		if(numberOfWheels == 4 && numberOfAxles == 2) {
			if(length <= 15){
				classVechicle = 2;
				typeVechicle = "Car";
				costWeekday = 3.20;
			}
			if(length > 15) {
				classVechicle = 4;
				typeVechicle = "Van";
				costWeekday = 4.40;
			}
		}
		if(numberOfWheels >= 4 && numberOfAxles >= 3 && numberOfAxles <= 6 && weight <= 2.0 && length > 15) {
			classVechicle = 3;
			typeVechicle = "Car with trailer";
			costWeekday = 3.80;
		}
		if(numberOfWheels >= 4 && numberOfAxles >= 3 && weight > 2 && weight <= 3.5 && length > 15) {
			classVechicle = 5;
			typeVechicle = "Small lorry/Bus";
			costWeekday = 8.00;
		}
		if(numberOfWheels >= 4 && numberOfAxles > 6 && weight > 3.5 && length > 15) {
			classVechicle = 6;
			typeVechicle = "Large lorry";
			costWeekday = 12.00;
		}
	}
	
	public String isWeekDayOrWeekend() {
		if(!isWeekday) {
			costWeekday = costWeekday * 0.75;
			return "weekend";
		}else
		return "weekday";
	}
}
