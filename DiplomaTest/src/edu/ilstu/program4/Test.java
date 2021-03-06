package edu.ilstu.program4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader file = new FileReader("dis.csv");
		Scanner sc = new Scanner(file);
		
		ArrayList<Double> prices = new ArrayList<>();
		String line = null;
		String[] lineArray;
		
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			lineArray = line.split(",");
			prices.add(Double.parseDouble(lineArray[1]));
		}
		
		double sumAll = 100 * prices.get(249);
		double allPlus = 0;
		double allMinus = 0;
		for (int i = prices.size() - 1; i >= 0; i--) {
			if((sumAll + prices.get(i)) <= 100 * prices.get(i)) {
				double plus = (prices.get(i) * 100) - sumAll;
				//int countShares =(int) (sumAll / prices.get(i));
				System.out.println("Plus: " + plus);
				allPlus += plus;
			}else if((sumAll - prices.get(i)) >= 100 * prices.get(i)) {
				double minus = sumAll - (prices.get(i) * 100);
				//int countShares =(int) (sumAll / prices.get(i));
				System.out.println("Minus: " + minus);
				allMinus += minus;
			}
		}
		
		System.out.println("All plus: " + allPlus);
		System.out.println("All minus: " + allMinus);
		
		//for (int i = 0; i < prices.size(); i++) {
		//	System.out.println("Price: " + prices.get(i));
		//}
	}

}
