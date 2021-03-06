import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws FileNotFoundException {
		File file1 = new File("data.txt");//read file
		FileReader file = new FileReader(file1);
		Scanner input = new Scanner(file);//scan file
		
		String line = null;//initialize line
		String[] arrayData;//array data
		line = input.nextLine();//get one line from file
		while (input.hasNextLine()) {//while file has next line
			line += " ";//add string space
			line += input.nextLine();//read line
		}
		arrayData = line.split(" ");//split the line through spaces and add to arrayData
		
		for (int i = 0; i < arrayData.length;i++) {
			System.out.println(arrayData[i]);//print all data
		}

		System.out.println(arrayData.length + " data values were read");
	}

}
