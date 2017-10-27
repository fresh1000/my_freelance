import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FaceBook extends Company{
	public FaceBook() {
		addDate();
		addPrice();
		addProfit();
	}
	
	public void addDate(){
		FileReader file;
		try {
			file = new FileReader("fb.csv");
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
			file = new FileReader("fb.csv");
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
	
}
