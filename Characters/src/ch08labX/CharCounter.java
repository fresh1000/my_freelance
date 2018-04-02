package ch08labX;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CharCounter {
	public static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		FileInputStream   inFile;
		FileOutputStream outFile;
		String 			 message;
		
		inFile = getInFile();
		if (inFile != null) {
			outFile = getOutFile();
			message = readAndWrite(inFile, outFile);
			System.out.println(message);
		}
		scnr.close();
	}
	
	public static String readAndWrite(FileInputStream inFile, FileOutputStream outFile) {
		Scanner readLine = new Scanner(inFile);
		PrintWriter writer = new PrintWriter(outFile);
		int counter = 0;
		int total = 0;
		while (readLine.hasNext()) {
			int charCount = readLine.nextLine().length(); 
			writer.println(counter + " " + charCount);
			total += charCount;
			counter++;
		}
		writer.close();
		readLine.close();
		String message = "The input file has " + counter + " lines and " + total 
				+ " total characters";
		return message;
	}

	public static FileOutputStream getOutFile() throws FileNotFoundException {
		System.out.print("Enter the name of the output file:");
		String fileName = scnr.nextLine();
		FileOutputStream file = new FileOutputStream(fileName);
		return file;
	}

	public static FileInputStream getInFile() throws FileNotFoundException {
		System.out.print("Enter the name of the input file:");
		String fileName = scnr.nextLine();
		FileInputStream file = new FileInputStream(fileName);
		return file;
	}

}
