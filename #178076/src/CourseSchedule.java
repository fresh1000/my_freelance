import java.util.ArrayList;
import java.util.Collections;

public class CourseSchedule {
	private String courseScheduleName;
	private ArrayList<Course> courses = new ArrayList<>();
	
	public CourseSchedule(String courseScheduleName) {
		this.courseScheduleName = courseScheduleName;
	}

	public String getCourseScheduleName() {
		return courseScheduleName;
	}

	public void setCourseScheduleName(String courseScheduleName) {
		this.courseScheduleName = courseScheduleName;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public void display() {
		System.out.println(toString());
		for (int i = 0; i < courses.size(); i++) {
			System.out.println(courses.get(i).toString());
		}
	}

	public void add(Course course) {
		courses.add(course);
		Collections.sort(courses);
	}

	public String toString() {
		return "=== Schedule for " + courseScheduleName + " ===";
	}
	
	

}
