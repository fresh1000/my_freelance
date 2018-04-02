import java.util.Arrays;

public class Student {
	private String firstName;
	private String lastName;
	private String studentId;
	private String studenEmail;
	private GradedActivity grades[] = new GradedActivity[4];
	
	public Student() {
		this.firstName = null;
		this.lastName = null;
		this.studentId = null;
		this.studenEmail = null;
		this.grades[0] = new GradedActivity(0.2);
		this.grades[1] = new GradedActivity(0.3);
		this.grades[2] = new GradedActivity(0.2);
		this.grades[3] = new GradedActivity(0.3);
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public double getLab() {
		return this.grades[0].getScore();
	}
	
	public double getMidterm() {
		return this.grades[1].getScore();
	}
	
	public double getEssay() {
		return this.grades[2].getScore();
	}
	
	public double getFinal() {
		return this.grades[3].getScore();
	}

	public String getLastName() {
		return lastName;
	}

	public String getStudenEmail() {
		return studenEmail;
	}

	public GradedActivity[] getGrades() {
		return grades;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStudenEmail(String studenEmail) {
		this.studenEmail = studenEmail;
	}

	public void setGrades(GradedActivity[] grades) {
		this.grades = grades;
	}
	
	public void setLab(double score) {
		this.grades[0].setScore(score);
	}
	
	public void setMidterm(double score) {
		this.grades[1].setScore(score);
	}
	
	public void setEssay(double score) {
		this.grades[2].setScore(score);
	}
	
	public void setFinal(double score) {
		this.grades[3].setScore(score);
	}

	public double getFinalGrade() {
		double sum = 0;
		for (int i = 0; i < grades.length; i++) {
			sum += grades[i].getScore() * grades[i].getWeight();
		}
		
		return sum;
	}

	public String toString() {
		return "FirstName: " + firstName + ", LastName: " + lastName + ", StudentId: " + studentId
				+ ", StudenEmail: " + studenEmail + ", Grades lab: " + grades[0].toString() + ", Grades midterm: " + grades[1].toString() +
				", Grades essay: " + grades[2].toString() +", Grades final: " + grades[3].toString();
	}
}
