import java.util.*;

/*
 * This program compares two applicants to
 * determine which one seems like the stronger
 * applicant. For each candidate I will need
 * either SAT or ACT scores plus a weighted GPA.
 * 
 * @author
 * 
 */
public class MIT131116 {
	/*
	 * method calculate overall score for SAT
	 */
	public static double calcOverallScoreSAT(int math, int verbal, double gpa, double maxGPA) {
		double examResult, gpaResult, overrallScore;

		examResult = (double) (2 * verbal + math) / 24;
		gpaResult = gpa / maxGPA * 100;
		overrallScore = examResult + gpaResult;

		return overrallScore;
	}

	/*
	 * method get input from user and return overall score SAT
	 */
	public static double scoresSAT() {
		Scanner sc = new Scanner(System.in);
		int math, verbal;
		double gpa, maxGPA;

		System.out.print("   SAT math? ");
		math = sc.nextInt();
		System.out.print("   SAT verbal? ");
		verbal = sc.nextInt();
		System.out.print("   overall GPA? ");
		gpa = sc.nextDouble();
		System.out.print("   max GPA?");
		maxGPA = sc.nextDouble();

		return calcOverallScoreSAT(math, verbal, gpa, maxGPA);
	}

	/*
	 * method for calculate overall score ACT
	 */
	public static double calcOverallScoreACT(int english, int math, int reading, int science, double gpa,
			double maxGPA) {
		double examResult, gpaResult, overrallScore;

		examResult = (double) (2 * reading + english + math + science) / 1.8;
		gpaResult = gpa / maxGPA * 100;
		overrallScore = examResult + gpaResult;

		return overrallScore;
	}

	/*
	 * method get input from user and return overall score ACT
	 */
	public static double scoresACT() {
		Scanner sc = new Scanner(System.in);
		int english, math, reading, science;
		double gpa, maxGPA;

		System.out.print("   ACT English? ");
		english = sc.nextInt();
		System.out.print("   ACT math? ");
		math = sc.nextInt();
		System.out.print("   ACT reading? ");
		reading = sc.nextInt();
		System.out.print("   ACT science? ");
		science = sc.nextInt();
		System.out.print("   overall GPA? ");
		gpa = sc.nextDouble();
		System.out.print("   max GPA?");
		maxGPA = sc.nextDouble();
		return calcOverallScoreACT(english, math, reading, science, gpa, maxGPA);
	}

	/*
	 * method get choice and call scoresSAT or scoresACT method and return score
	 */
	public static double choiceInfo(int choice) {
		double scores = 0;
		switch (choice) {
		case 1:
			scores = scoresSAT();
			break;
		case 2:
			scores = scoresACT();
			break;
		default:
			break;
		}

		return scores;
	}
	/*
	 * method compare applicant
	 */
	public static void compareApplicant(double firstApplicant, double secondApplicant) {
		if (firstApplicant > secondApplicant) {
			System.out.println("The first applicant seems to be better");
		} else if (firstApplicant < secondApplicant) {
			System.out.println("The second applicant seems to be better");
		} else
			System.out.println("The two applicants seem to be equal");
	}
	/*
	 * print menu and call choiceInfo, compareApplicant
	 */
	public static void menu() {
		Scanner sc = new Scanner(System.in);
		double firstApplicant, secondApplicant;
		int choice;
		System.out.println("Information for the first applicant:");
		System.out.print("   do you have 1) SAT scores or 2) ACT scores? ");
		choice = sc.nextInt();
		firstApplicant = choiceInfo(choice);

		System.out.println("Information for the second applicant:");
		System.out.print("   do you have 1) SAT scores or 2) ACT scores? ");
		choice = sc.nextInt();
		secondApplicant = choiceInfo(choice);

		System.out.println("First applicant overall score = " + firstApplicant);
		System.out.println("Second applicant overall score = " + secondApplicant);
		compareApplicant(firstApplicant, secondApplicant);

	}
	/*
	 * main method
	 */
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);//for scanner read double with "." 
		System.out.println("This program compares two applicants to determine which one\n"
				+ "seems like the stronger applicant. For each candidate I will need either\n"
				+ "SAT or ACT scores plus a weighted GPA.\n");
		menu();//call menu
	}

}
