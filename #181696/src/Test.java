
public class Test {

	public static void main(String[] args) {
		int age = 29;
		String name = "Steven Brown";
		String uni = "Flinders";
		Student student = new Student(name);
		System.out.println(student.aboutMe());
		Student s2 = new Student(name, uni);
		System.out.println(s2.aboutMe());
		Student s3 = new Student(name, uni, age);
		System.out.println(s3.aboutMe());
	}

}
