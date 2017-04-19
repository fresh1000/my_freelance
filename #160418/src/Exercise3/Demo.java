package Exercise3;

public class Demo {

	public static void main(String[] args) {
		Person person1 = new Person();
		Person person2 = new Person();
		person1.setName("Jonh");
		person2.setName("Jonh");
		System.out.println(person1.hasSameName(person2));//if equals name print true else false
		System.out.println(person1.toString());
		
		Student student1 = new Student();
		Student student2 = new Student();
		student1.setName("Mandy");
		student2.setName("Fred");
		student1.setStudentNumber(102);
		student2.setStudentNumber(123);
		System.out.println(student1.equals(student2));//if equals Name and studentNumber print true else false
		System.out.println(student2.toString());
	}

}
