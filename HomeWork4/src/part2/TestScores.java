package part2;

import java.util.Random;
import java.util.Scanner;

public class TestScores {
	
	public static int findLowest(Student[] students) {
		int max = 0;//for max score
		int index = 0;//for get index with max score
		for (int i = 0; i < students.length; i++) {
			if(students[i].getScore() > max) {
				index = i;//set indexLow to i
			}
		}
		
		return index;
	}
	
	public static double average(Student[] students) {
		int sum = 0;
		double average;
		for (int i = 0; i < students.length; i++) {
			sum += students[i].getScore();//sum score all students
		}
		average = sum / students.length;
		return average;
	}

	public static void main(String[] args) {
		Student[] students = new Student[5];//array size 5
		Scanner sc = new Scanner(System.in);//for read from console
		Random random = new Random();//random for score
		String name;
		for (int i = 0 ; i < students.length; i++) {
			System.out.println("Enter a student's name");
			students[i] = new Student();//initialize student
			name = sc.next();
			students[i].name = name;
			students[i].setScore(random.nextInt(46) + 55);//random 55 to 100
			System.out.println(students[i].toString());//print info
		}
		
		int indexLow = findLowest(students);//get low index
		System.out.println(students[indexLow].name + " has the lowest score. Their score is " + students[indexLow].getScore());
		
		double average = average(students);//get average
		System.out.println("The average is " + average);
		
		System.out.print("After the curve: ");
		for (int i = 0 ; i < students.length; i++) {
			students[i].curve(average);//curve score student
			System.out.println(students[i].toString());//print info
		}
		
		
	}

}
