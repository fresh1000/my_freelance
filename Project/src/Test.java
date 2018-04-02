
public class Test {

	public static void main(String[] args) {
		Course course = new Course("Test", "Math", "Will", 4);
		course.setCourseName("Test2");
		course.setCourseDescription("Math1");
		course.setCourseInstructor("Sam");
		
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		
		student1.setFirstName("Edd");
		student1.setLastName("Smit");
		student1.setStudentId("1232");
		student1.setStudenEmail("Email1");
		student1.setLab(60);
		student1.setMidterm(76);
		student1.setEssay(80);
		student1.setFinal(90);
		System.out.println("Student 1: " + student1.toString());
		
		student2.setFirstName("Sam");
		student2.setLastName("Egt");
		student2.setStudentId("1332");
		student2.setStudenEmail("Email2");
		student2.setLab(80);
		student2.setMidterm(76);
		student2.setEssay(80);
		student2.setFinal(70);
		
		student3.setFirstName("Teo");
		student3.setLastName("Wall");
		student3.setStudentId("1432");
		student3.setStudenEmail("Email3");
		student3.setLab(30);
		student3.setMidterm(10);
		student3.setEssay(70);
		student3.setFinal(90);
		
		student4.setFirstName("Tim");
		student4.setLastName("Kell");
		student4.setStudentId("1732");
		student4.setStudenEmail("Email4");
		student4.setLab(70);
		student4.setMidterm(46);
		student4.setEssay(40);
		student4.setFinal(80);
		
		course.setOneStudent(0, student1);
		course.setOneStudent(1, student2);
		course.setOneStudent(2, student3);
		course.setOneStudent(3, student4);
		
		System.out.println("Student 1 final:" + student1.getFinalGrade());
		System.out.println("Student 2 final:" + student2.getFinalGrade());
		System.out.println("Student 3 final:" + student3.getFinalGrade());
		System.out.println("Student 4 final:" + student4.getFinalGrade());
		System.out.println();
		
		System.out.println("Average lab: " + course.getLabAverage());
		System.out.println("Average midterm: " + course.getMidtermAverage());
		System.out.println("Average essay: " + course.getEssayAverage());
		System.out.println("Average final: " + course.getFinalAverage());
		
		System.out.println("Highest lab: " + course.getLabHighest());
		System.out.println("Highest midterm: " + course.getMidtermHighest());
		System.out.println("Highest essay: " + course.getEssayHighest());
		System.out.println("Highest final: " + course.getFinalHighest());
		
		System.out.println("Lowest lab: " + course.getLabLowest());
		System.out.println("Lowest midterm: " + course.getMidtermLowest());
		System.out.println("Lowest essay: " + course.getEssayLowest());
		System.out.println("Lowest final: " + course.getFinalLowest());
		
		System.out.println("Student 1 average:" + course.getStudentAverage(0));
		System.out.println("Student 2 average:" + course.getStudentAverage(1));
		System.out.println("Student 3 average:" + course.getStudentAverage(2));
		System.out.println("Student 4 average:" + course.getStudentAverage(3));
		
		System.out.println("Class average:" + course.getClassAverage());
	}

}
