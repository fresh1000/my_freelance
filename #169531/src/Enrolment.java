import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Enrolment {

	public static void main(String[] args) throws FileNotFoundException {
		File fileStudent = new File(args[0]);
		FileReader file = new FileReader(fileStudent);
		Scanner inputStudent = new Scanner(file);
		
		String lineStud;
		String[] lineVecStud;
		String firstName = null;
		String lastName = null;
		String course = null;
		int studentNumber = 0;
		String account = null;
		String fullName;
		String email;
		int countLine = 0;
		
		while (inputStudent.hasNextLine()) {
			if(countLine == 0) {
				lineStud = inputStudent.nextLine();
				lineVecStud = lineStud.split(" ");
				firstName = lineVecStud[2];
			}
			if(countLine == 1) {
				lineStud = inputStudent.nextLine();
				lineVecStud = lineStud.split(" ");
				lastName = lineVecStud[2];
			}
			if(countLine == 2) {
				lineStud = inputStudent.nextLine();
				lineVecStud = lineStud.split(" ");
				course = lineVecStud[1];
			}
			if(countLine == 3) {
				lineStud = inputStudent.nextLine();
				lineVecStud = lineStud.split(" ");
				studentNumber = Integer.parseInt(lineVecStud[2]);
			}
			if(countLine == 4) {
				lineStud = inputStudent.nextLine();
				lineVecStud = lineStud.split(" ");
				account = lineVecStud[1];
			}
			countLine++;
		}
		
		fullName = firstName + " " + lastName;
		email = account + "@uow.edu.au";
		course += "E";
		Student std = new Student(fullName, studentNumber, email, course);
		std.displayStudInfo();
		
		
		
		
		File fileSubject = new File(args[1]);
		FileReader file2 = new FileReader(fileSubject);
		Scanner inputSub = new Scanner(file2);
		
		String lineSub;
		String[] lineVecSub;
		String sCode = null;
		String session = null;
		int year = 0;
		int countLineSub = 0;
		
		while (inputSub.hasNextLine()) {
			if(countLineSub == 0) {
				lineSub = inputSub.nextLine();
				lineVecSub = lineSub.split(" ");
				sCode = lineVecSub[2];
			}
			if(countLineSub == 1) {
				lineSub = inputSub.nextLine();
				lineVecSub = lineSub.split(" ");
				session = lineVecSub[1];
			}
			if(countLineSub == 2) {
				lineSub = inputSub.nextLine();
				lineVecSub = lineSub.split(" ");
				year = Integer.parseInt(lineVecSub[1]);
			}
			countLineSub++;
		}
		
		Subject sub = new Subject(sCode, session, year);
		sub.displaySubjectInfo();
	}

}
