import java.util.Locale;
import java.util.Scanner;

public class TunnelTollChargeUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		
		int numOfWheels;
		int numOfAx;
		int length;
		double weight;
		boolean isWeek;
		
		System.out.println("Input the number of wheels (an integer greater than 0): ");
		numOfWheels = sc.nextInt();
		
		if(numOfWheels < 2) {
			System.out.println("Invalid number of wheels!");
			System.exit(0);
		}
		
		if(numOfWheels < 4) {
			System.out.println("Input true if travelling on a weekday (Mon-Fri) and false otherwise: ");
			isWeek = sc.nextBoolean();
			
			TunnelTollCharge class1 = new TunnelTollCharge(numOfWheels, isWeek);
			class1.typeVechicle();
			
			System.out.println("Wheels: " + class1.getNumberOfWheels()+ ", " + class1.isWeekDayOrWeekend());
			//System.out.println();
			System.out.println("Vehicle class: " + class1.getClassVechicle());
			System.out.println("Vehicle type: " + class1.getTypeVechicle());
			System.out.println("Vehicle charge: " + class1.getCostWeekday());
		}
		
		if(numOfWheels >= 4) {
			System.out.println("Input the length of the vehicle in feet (a double greater than 0.0): ");
			length = sc.nextInt();
		
			if(length <= 0) {
				System.out.println("Invalid length!");
				System.exit(0);
			}
		
			System.out.println("Input the number of axles (an integer greater than 2): ");
			numOfAx = sc.nextInt();
			if(numOfAx < 2) {
				System.out.println("Invalid number of axles!");
				System.exit(0);
			}
			if(numOfAx == 2) {
				System.out.println("Input true if travelling on a weekday (Mon-Fri) and false otherwise: ");
				isWeek = sc.nextBoolean();
				
				TunnelTollCharge class1 = new TunnelTollCharge(numOfWheels, length, numOfAx, isWeek);
				class1.typeVechicle();
				
				System.out.println("Wheels: " + class1.getNumberOfWheels() + ", length:" + class1.getLength() +
				", axles: " + class1.getNumberOfAxles() + ", " + class1.isWeekDayOrWeekend());
				//System.out.println();
				System.out.println("Vehicle class: " + class1.getClassVechicle());
				System.out.println("Vehicle type: " + class1.getTypeVechicle());
				System.out.println("Vehicle charge: " + class1.getCostWeekday());
			}
		
			if(numOfAx > 2){
				System.out.println("Input the weight of the vehicle in metric tons: ");
				weight = sc.nextDouble();
				if(weight <= 0) {
					System.out.println("Invalid number weight!");
					System.exit(0);
				}
				System.out.println("Input true if travelling on a weekday (Mon-Fri) and false otherwise: ");
				isWeek = sc.nextBoolean();
				
				TunnelTollCharge class1 = new TunnelTollCharge(numOfWheels, length, numOfAx, weight, isWeek);
				class1.typeVechicle();
				
				System.out.println("Wheels: " + class1.getNumberOfWheels() + ", length:" + class1.getLength() +
				", axles: " + class1.getNumberOfAxles() +", weight: " +class1.getWeight()+ ", " + class1.isWeekDayOrWeekend());
				//System.out.println();
				System.out.println("Vehicle class: " + class1.getClassVechicle());
				System.out.println("Vehicle type: " + class1.getTypeVechicle());
				System.out.println("Vehicle charge: " + class1.getCostWeekday());
			}
	  }
	}

}
