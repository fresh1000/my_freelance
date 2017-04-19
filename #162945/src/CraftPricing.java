import java.util.Locale;
import java.util.Scanner;

public class CraftPricing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
		String nameProduct;
		double costOfMaterials;
		int workHours;
		double retailPrice;
		System.out.print("Enter name of a product: ");
		nameProduct = sc.nextLine();
		System.out.print("Enter cost of materials: $ ");
		costOfMaterials = sc.nextDouble();
		System.out.print("Enter number of hours of work: ");
		workHours = sc.nextInt();
		retailPrice = (double) (0.75 * (costOfMaterials + (14 * workHours)) + 6);
		System.out.println("Name of product: " + nameProduct);
		System.out.printf("Retail price: $ %.2f", retailPrice);
	}

}
