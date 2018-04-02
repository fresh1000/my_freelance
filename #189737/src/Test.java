import java.util.Scanner;

public class Test {
	//print menu
	public static void printMenu() {
		System.out.println("1. Count the number of vowels in the string");
		System.out.println("2. Count the number of consonants in the string");
		System.out.println("3. Count both the vowels and consonants in the string");
		System.out.println("4. Enter another string");
		System.out.println("5. Exit the program");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//scanner to read input
		int choice = 0;//get choice
		
		System.out.print("Enter a string: ");
		String line = sc.nextLine();//get string
		Chars chars = new Chars(line);//create Chars object
		//repeat while choice not equals 5(exit)
		while (choice != 5) {
			printMenu();//print menu
			System.out.print("Choice: ");
			choice = sc.nextInt();//read choice
			switch (choice) {
			case 1:
				//print count vowels
				System.out.println("Count vowels: " + chars.vowelsCount());
				break;
			case 2:
				//print count consonants
				System.out.println("Count consonants: " + chars.consonantsCount());
				break;
			case 3:
				//both count
				System.out.println("Both count: " + chars.bothCount());
				break;
			case 4:
				//enter new string
				System.out.print("Enter string: ");
				sc.nextLine();
				String another = sc.nextLine();
				chars.setStringLine(another);//set to chars
				break;
			default:
				break;
			}
		}
		
	}

}
