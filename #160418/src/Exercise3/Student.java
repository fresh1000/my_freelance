package Exercise3;

public class Student extends Person {
	private int studentNumber;

	public Student() {

	}

	public void reset(String newName, int newNumber) {
		setName(newName);
		this.studentNumber = newNumber;
	}

	public String toString() {
		return "Student [name= "+ getName() +" studentNumber= " + studentNumber + "]";
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int n) {
		this.studentNumber = n;
	}

	public boolean equals(Student anotherStudent) {
		//if all attributes equals
		if (getName().equals(anotherStudent.getName()) && studentNumber == anotherStudent.getStudentNumber()) {
			return true;
		} else
			return false;
	}
}
