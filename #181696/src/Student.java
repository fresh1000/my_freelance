
public class Student {
	private int age;
	private String name;
	private String uni;

	public Student(String name) {
		this.name = name;
		this.uni = null;
		this.age = 0;
		System.out.println("Student object created.");
	}

	public Student(String name, String uni) {
		this.name = name;
		this.uni = uni;
		this.age = 0;
		System.out.println("Student object created.");
	}

	public Student(String name, String uni, int age) {
		this.age = age;
		this.name = name;
		this.uni = uni;
		System.out.println("Student object created.");
	}

	public String aboutMe() {
		return "\tName: " + this.name + "\n\tUni: " + this.uni + "\n\tAge: " + this.age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getUni() {
		return uni;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUni(String uni) {
		this.uni = uni;
	}

}
