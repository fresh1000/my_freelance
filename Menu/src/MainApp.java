import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
	
	public static void menu() {
		System.out.print("Menu\n1.Soup\n2.Pizza\n3.Panini\n4.Beer\n5.Cola"
				+ "\n6.Wine\n7.Salad\n8.Ice cream\n9.Tea\n10.Potato\nEnter your choice:");
	}
	
	public static void choice(ArrayList<Item> items) {
		Scanner sc = new Scanner(System.in);
		int choice;
		int quantity;
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Soup");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Soup(quantity));
			break;
		case 2:
			System.out.println("Pizza");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Pizza(quantity));
			break;
		case 3:
			System.out.println("Panini");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Panini(quantity));
			break;
		case 4:
			System.out.println("Beer");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Beer(quantity));
			break;
		case 5:
			System.out.println("Cola");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Cola(quantity));
			break;
		case 6:
			System.out.println("Wine");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Wine(quantity));
			break;
		case 7:
			System.out.println("Salad");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Salad(quantity));
			break;
		case 8:
			System.out.println("Ice cream");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new IceCream(quantity));
			break;
		case 9:
			System.out.println("Tea");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Tea(quantity));
			break;
		case 10:
			System.out.println("Potato");
			System.out.println("Enter quantity:");
			quantity = sc.nextInt();
			items.add(new Potato(quantity));
			break;
		default:
			System.out.println("invalid");
			break;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Item> items = new ArrayList<Item>();
		
		double totalCost = 0;
		double amountDue = 0;
		double payment = 0;
		boolean cont = true;
		String answer = "";
		
		while(cont) {
			menu();
			choice(items);
			System.out.print("Continue?(y/n):");
			answer = sc.next();
			if(answer.equals("n")) {
				cont = false;
			}
		}
		
		for(int i = 0; i < items.size(); i++) {
			totalCost += items.get(i).getPrice();
			System.out.println(items.get(i).toString());
		}
		System.out.println();
		System.out.println("Total cost: $" + totalCost);
		System.out.println();
		System.out.print("Enter payment: $");
		payment = sc.nextDouble();
		amountDue = payment - totalCost;
		System.out.println("Amount due: $" + amountDue);
	}

}
