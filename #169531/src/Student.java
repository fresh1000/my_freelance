
public class Student {
	private String fullName;
	private int stdNumber;
	private String email;
	private String course;
	
	public Student() {
		fullName = null;
		stdNumber = 0;
		email = null;
		course = null;
	}
	

	public Student(Student other) {
		this(other.getFullName(), other.getStdNumber(),other.getEmail(),other.getCourse());
	}


	public Student(String fullName, int stdNumber, String email, String course) {
		this.fullName = fullName;
		this.stdNumber = stdNumber;
		this.email = email;
		this.course = course;
	}

	public String getFullName() {
		return fullName;
	}

	public int getStdNumber() {
		return stdNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getCourse() {
		return course;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setStdNumber(int stdNumber) {
		this.stdNumber = stdNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public void displayStudInfo() {
		System.out.println("STUDENT");
		System.out.println("  Full name: " + fullName);
		System.out.println("  Course: " + course);
		System.out.println("  Student number: " + stdNumber);
		System.out.println("  Email: " + email);
	}
	
}
