import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Student name: ");
		String studentName = sc.nextLine();
		
		System.out.println("Course: ");
		int course = sc.nextInt();
		
		System.out.println("Grade in quiz: ");
		int quiz = sc.nextInt();
		
		System.out.println("Seatwork: ");
		int seatwork = sc.nextInt();
		
		System.out.println("Laboratory exercises: ");
		int lab = sc.nextInt();
		
		System.out.println("Assignment: ");
		int assignment = sc.nextInt();
		
		System.out.println("Prelim exam: ");
		int exam = sc.nextInt();
		
		double grade = quiz * 0.25 + seatwork * 0.1 + lab * 0.2 + assignment * 0.05 + exam * 0.4;
		System.out.println("Prelim Grade: " + grade);
		
		
	}

}
