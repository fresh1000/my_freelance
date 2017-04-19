package AssignmentA;

import java.util.Scanner;

public class StringMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str, str1, str2, str3;
		System.out.print("Enter string: ");
		str = sc.nextLine();
		str1 = str.substring(0, 1).toUpperCase();
		str2 = str.substring(1);
		str3 = str1 + str2;
		System.out.println("Result: " + str3);
	}

}
