import java.util.Scanner;

public class AnimalInfo {
	//main method
	public static void main(String[] args) {
		//scanner use for read info from console 
		Scanner sc = new Scanner(System.in);
		
		//variable for choice user
		int choice = 0;
		//variable for end while loop
		boolean endLoop = false;

		//while variable end loop is false
		while (!endLoop) {
			//print menu
			System.out.println("Select animal");
			System.out.println("1.Dog");
			System.out.println("2.Cat");
			System.out.println("3.Parrot");
			System.out.println("4.Quit");
			System.out.print("Select your choice:");

			//read user input
			choice = sc.nextInt();

			//switch for choice
			switch (choice) {
			case 1:
				//create instance of class Dog
				Animal dog = new Dog();
				//display info
				dog.displayInfo();
				break;
			case 2:
				//create instance of class Cat
				Animal cat = new Cat();
				//display info
				cat.displayInfo();
				break;
			case 3:
				//create instance of class Parrot
				Animal parrot = new Parrot();
				//display info
				parrot.displayInfo();
				break;
			case 4:
				System.out.println("Quit");
				//end while loop
				endLoop = true;
				break;
			default:
				System.out.println("Invalid");
				break;
			}
		}
	}

}
