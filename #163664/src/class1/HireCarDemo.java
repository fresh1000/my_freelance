package class1;

public class HireCarDemo {

	public static void main(String[] args) {
		HireCar car1 = new HireCar("Toyota", "214SFG", 12302, 4000, 3000);
		HireCar car2 = new HireCar("Tesla", "ASDW242", 2000, 1000, 1500);
		System.out.println(car1.toString());
		System.out.println(car2.toString());
		System.out.println("Service due for first car: " + car1.serviceDue());
		System.out.println("Service due for second car: " + car2.serviceDue());
		
		System.out.println("First car manufacturer: " + car1.getManufacturer());
		System.out.println("Second car manufacturer: " + car2.getManufacturer());
		
		System.out.println("First car difference between mileage: " + car1.differenceMileage(14000) + " miles");
	}

}
