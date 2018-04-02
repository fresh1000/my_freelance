import java.util.Locale;
import java.util.Scanner;

public class Week6Prog {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);//scanner use for read from console
		
		Boat boat1 = new Boat();//create object boat1
		System.out.print("Enter the registered name for Boat 1: ");
		String regName = sc.nextLine();//read name
		boat1.setRegisteredName(regName);//set name
		System.out.print("Enter the category for Boat 1: ");
		boat1.setCategory(sc.next());//read and set category
		sc.nextLine();
		System.out.print("Enter the number Of cabins for Boat 1: ");
		boat1.setNumberOCabins(sc.nextInt());//read and set number of cabins
		sc.nextLine();
		System.out.print("Enter the length of Boat 1 in ft.: ");
		boat1.setLength(sc.nextDouble());//read and set length
		sc.nextLine();
		System.out.print("Does Boat 1 have sails? true or false?: ");
		boat1.setHasSails(sc.nextBoolean());//read and set sails
		sc.nextLine();
		
		Boat boat2 = new Boat();//create object boat2
		System.out.print("Enter the registered name for Boat 2: ");
		regName = sc.nextLine();//read name
		boat2.setRegisteredName(regName);//set name
		System.out.print("Enter the category for Boat 2: ");
		boat2.setCategory(sc.next());//read and set category
		sc.nextLine();
		System.out.print("Enter the number Of cabins for Boat 2: ");
		boat2.setNumberOCabins(sc.nextInt());//read and set number of cabins
		sc.nextLine();
		System.out.print("Enter the length of Boat 2 in ft.: ");
		boat2.setLength(sc.nextDouble());//read and set length
		sc.nextLine();
		System.out.print("Does Boat 2 have sails? true or false?: ");
		boat2.setHasSails(sc.nextBoolean());//read and set sails
		sc.nextLine();
		
		Boat boat3 = new Boat();//create object boat3
		System.out.print("Enter the registered name for Boat 3: ");
		regName = sc.nextLine();//read name
		boat3.setRegisteredName(regName);//set name
		System.out.print("Enter the category for Boat 3: ");
		boat3.setCategory(sc.next());//read and set category
		sc.nextLine();
		System.out.print("Enter the number Of cabins for Boat 3: ");
		boat3.setNumberOCabins(sc.nextInt());//read and set number of cabins
		sc.nextLine();
		System.out.print("Enter the length of Boat 3 in ft.: ");
		boat3.setLength(sc.nextDouble());//read and set length
		sc.nextLine();
		System.out.print("Does Boat 3 have sails? true or false?: ");
		boat3.setHasSails(sc.nextBoolean());//read and set sails
		sc.nextLine();
		
		double averageLength = (boat1.getLength() + boat2.getLength() + boat3.getLength()) / 3.0;//calculate average length
		
		int minNumOfCabins, maxNumOfCabins;
		//find minimum number of cabins
		minNumOfCabins = boat1.getNumberOCabins();
		if (minNumOfCabins > boat2.getNumberOCabins()) {
			minNumOfCabins = boat2.getNumberOCabins();
		}
		if (minNumOfCabins > boat3.getNumberOCabins()) {
			minNumOfCabins = boat3.getNumberOCabins();
		}
		//find maximum number of cabins
		maxNumOfCabins = boat1.getNumberOCabins();
		if (maxNumOfCabins < boat2.getNumberOCabins()) {
			maxNumOfCabins = boat2.getNumberOCabins();
		}
		if (maxNumOfCabins < boat3.getNumberOCabins()) {
			maxNumOfCabins = boat3.getNumberOCabins();
		}
		
		double longest = 0;
		String name = null;
		
		//find longest boat length with isHasSails true
		if (longest < boat1.getLength() && boat1.isHasSails()) {
			longest = boat1.getLength();
			name = boat1.getRegisteredName();
		}
		if (longest < boat2.getLength() && boat2.isHasSails()) {
			longest = boat2.getLength();
			name = boat2.getRegisteredName();
		}
		if (longest < boat3.getLength() && boat3.isHasSails()) {
			longest = boat3.getLength();
			name = boat3.getRegisteredName();
		}
		
		System.out.println("\nThe boats average length is: " + averageLength + " ft.");
		System.out.println("The boats minimum number of cabins is: " + minNumOfCabins);
		System.out.println("The boats maximum number of cabins is: " + maxNumOfCabins);
		System.out.println("The longest boat with sails is: "+ name + " measuring " + longest +" ft.");
		
	}

}
