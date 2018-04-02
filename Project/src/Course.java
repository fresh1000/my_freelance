import java.util.Arrays;

public class Course implements Analyzable{
	private String courseName;
	private String courseDescription;
	private String courseInstructor;
	private int numberStudents;
	private Student students[];
	
	public Course(String courseName, String courseDescription, String courseInstructor, int numberStudents) {
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseInstructor = courseInstructor;
		this.numberStudents = numberStudents;
		this.students = new Student[numberStudents];
	}

	public String getCourseName() {
		return courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public int getNumberStudents() {
		return numberStudents;
	}
	
	public Student getStudent(int number) {
		if (number < students.length && number >= 0) {
			return students[number];
		}else
			throw new IllegalArgumentException("Invalid number in array students");
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	public void setNumberStudents(int numberStudents) {
		this.numberStudents = numberStudents;
	}
	
	public void setOneStudent(int number, Student student) {
		if (number < students.length && number >= 0) {
			students[number] = student;
		}else
			throw new IllegalArgumentException("Invalid number in array students");
	}

	@Override
	public double getLabAverage() {
		double average = 0;
		for (int i = 0; i < students.length; i++) {
			average += students[i].getLab();
		}
		return average / students.length;
	}

	@Override
	public double getMidtermAverage() {
		double average = 0;
		for (int i = 0; i < students.length; i++) {
			average += students[i].getMidterm();
		}
		return average / students.length;
	}

	@Override
	public double getEssayAverage() {
		double average = 0;
		for (int i = 0; i < students.length; i++) {
			average += students[i].getEssay();
		}
		return average / students.length;
	}

	@Override
	public double getFinalAverage() {
		double average = 0;
		for (int i = 0; i < students.length; i++) {
			average += students[i].getFinal();
		}
		return average / students.length;
	}

	@Override
	public double getLabHighest() {
		double highest = 0;
		for (int i = 0; i < students.length; i++) {
			if (highest < students[i].getLab()) {
				highest = students[i].getLab();
			}
		}
		return highest;
	}

	@Override
	public double getMidtermHighest() {
		double highest = 0;
		for (int i = 0; i < students.length; i++) {
			if (highest < students[i].getMidterm()) {
				highest = students[i].getMidterm();
			}
		}
		return highest;
	}

	@Override
	public double getEssayHighest() {
		double highest = 0;
		for (int i = 0; i < students.length; i++) {
			if (highest < students[i].getEssay()) {
				highest = students[i].getEssay();
			}
		}
		return highest;
	}

	@Override
	public double getFinalHighest() {
		double highest = 0;
		for (int i = 0; i < students.length; i++) {
			if (highest < students[i].getFinal()) {
				highest = students[i].getFinal();
			}
		}
		return highest;
	}

	@Override
	public double getLabLowest() {
		double lowest = 100;
		for (int i = 0; i < students.length; i++) {
			if (lowest > students[i].getLab()) {
				lowest = students[i].getLab();
			}
		}
		return lowest;
	}

	@Override
	public double getMidtermLowest() {
		double lowest = 100;
		for (int i = 0; i < students.length; i++) {
			if (lowest > students[i].getMidterm()) {
				lowest = students[i].getMidterm();
			}
		}
		return lowest;
	}

	@Override
	public double getEssayLowest() {
		double lowest = 100;
		for (int i = 0; i < students.length; i++) {
			if (lowest > students[i].getEssay()) {
				lowest = students[i].getEssay();
			}
		}
		return lowest;
	}

	@Override
	public double getFinalLowest() {
		double lowest = 100;
		for (int i = 0; i < students.length; i++) {
			if (lowest > students[i].getFinal()) {
				lowest = students[i].getFinal();
			}
		}
		return lowest;
	}

	@Override
	public double getStudentAverage(int studentNumber) {
		return students[studentNumber].getFinalGrade();
	}

	@Override
	public double getClassAverage() {
		double average = 0;
		for (int i = 0; i < students.length; i++) {
			average += students[i].getFinalGrade();
		}
		return average / students.length;
	}

}
