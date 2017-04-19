package Pyramid;

import java.util.Scanner;

public class PrintPyramid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, tempSpaces;
		System.out.print("How tall do you want the pyramid to be : ");
		n = sc.nextInt();
		System.out.println();
		tempSpaces = n;
		for (int i = 1; i <= n; i++) {
			for (int j= 1; j < tempSpaces; j++) {
				System.out.print(" ");
			}
			tempSpaces--;
			for (int k = 1; k <= 2 * i - 1; k++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}

}
