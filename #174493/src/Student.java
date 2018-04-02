
public class Student {
	private String studentFName;
	private String studentLName;
	private int testScore;
	private char grade;
	
	public Student(String studentFName, String studentLName, int testScore) {
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.testScore = testScore;
		setGrade();
	}

	public String getStudentFName() {
		return studentFName;
	}

	public String getStudentLName() {
		return studentLName;
	}

	public int getTestScore() {
		return testScore;
	}

	public char getGrade() {
		return grade;
	}

	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}

	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}

	public void setTestScore(int testScore) {
		this.testScore = testScore;
	}
	/*
	 * Method for set relevant grade
	 */
	public void setGrade() {
		if(this.testScore >= 90) {
			this.grade = 'A';
		}else if(this.testScore < 90 && this.testScore >= 80) {
			this.grade = 'B';
		}else if(this.testScore < 80 && this.testScore >= 70) {
			this.grade = 'C';
		}else			
			this.grade = 'D';
	}
	
}
