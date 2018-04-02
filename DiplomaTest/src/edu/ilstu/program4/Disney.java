package edu.ilstu.program4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Disney {
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<Double> price = new ArrayList<Double>();
	
	public Disney() {
		addDate();
		addPrice();
	}
	
	public void addDate(){
		FileReader file;
		try {
			file = new FileReader("dis.csv");
			Scanner sc = new Scanner(file);
			
			String line = null;
			String[] lineArray;
			
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				lineArray = line.split(",");
				date.add(lineArray[0]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void addPrice(){
		FileReader file;
		try {
			file = new FileReader("dis.csv");
			Scanner sc = new Scanner(file);
			
			String line = null;
			String[] lineArray;
			
			while(sc.hasNextLine()) {
				line = sc.nextLine();
				lineArray = line.split(",");
				price.add(Double.parseDouble(lineArray[4]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getDate() {
		return date;
	}

	public ArrayList<Double> getPrice() {
		return price;
	}

	public void setDate(ArrayList<String> date) {
		this.date = date;
	}

	public void setPrice(ArrayList<Double> price) {
		this.price = price;
	}
	
	
	
}
