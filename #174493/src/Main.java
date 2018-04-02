import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	public static Student[] students = new Student[20];//array students
	
	/*
	 * Method for read from file and add to array students 
	 */
	public static void readFromArray() throws FileNotFoundException {
		FileReader file = new FileReader("Data.txt");//open file
		Scanner sc = new Scanner(file);//scanner
		int counter = 0;
		while(sc.hasNextLine()) {//while file has next line
			String line = sc.nextLine();
			String[] lineVec = line.split(" ");//split line by " " and save to array lineVec
			students[counter] = new Student(lineVec[0], lineVec[1], Integer.parseInt(lineVec[2]));
			counter++;
		}
		
	}
	/*
	 * Method for find and return max score
	 */
	public static int findHighestScore() {
		int maxScore = 0;
		for (int i = 0; i < students.length; i++) {
			if(students[i].getTestScore() > maxScore) {
				maxScore = students[i].getTestScore();//set max score
			}
		}
		
		return maxScore;
	}
	/*
	 * Method for print student having the highest score
	 */
	public static void nameStudentsHighestScore(int max) {
		for (int i = 0; i < students.length; i++) {
			if(students[i].getTestScore() == max) {
				String fullName = students[i].getStudentLName() + ", " + students[i].getStudentFName();
				System.out.printf("%-30s\n", fullName);
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		readFromArray();//read info from file
		System.out.printf("%-30s%10s%10s\n", "Student Name", "TestScore", "Grade");
		//print all student info
		for (int i = 0; i < students.length; i++) {
			String fullName = students[i].getStudentLName() + ", " + students[i].getStudentFName();
			System.out.printf("%-30s%10d%10c\n", fullName, students[i].getTestScore(), students[i].getGrade());
		}
		//set max score
		int maxScore = findHighestScore();
		System.out.println("\nHighest Test Score: " + maxScore);
		System.out.println("Students having the highest test score:");
		nameStudentsHighestScore(maxScore);//print student with max score
	}

}
