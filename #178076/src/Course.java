
public class Course implements Comparable<Course>{
	private String courseName;
	private String lector;
	
	public Course(String courseName, String lector) {
		this.courseName = courseName;
		this.lector = lector;
	}

	public String getCourseName() {
		return courseName;
	}

	public String getLector() {
		return lector;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public void setLector(String lector) {
		this.lector = lector;
	}

	public String toString() {
		return "Course: " + courseName + ", Lector: " + lector;
	}

	public int compareTo(Course course) {
        return courseName.compareTo(course.getCourseName());
	}
	

}
