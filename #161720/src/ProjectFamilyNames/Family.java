package ProjectFamilyNames;

import java.util.Scanner;

public class Family {

	public static void main(String[] args) {
		String[] familyName = new String[5];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter five names:");
		for (int i = 0; i < familyName.length; i++) {
			familyName[i] = sc.nextLine();
		}
		System.out.println("You entered the following family names: ");
		for (int i = 0; i < familyName.length; i++) {
			System.out.println(familyName[i]);
		}
	}

}
