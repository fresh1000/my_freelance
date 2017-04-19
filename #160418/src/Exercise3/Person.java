package Exercise3;

public class Person {
	private String name;

	public Person() {

	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String toString() {
		return "Person [name=" + name + "]";
	}

	public boolean hasSameName(Person anotherPerson) {
		if (name.equals(anotherPerson.getName())) {
			return true;
		} else
			return false;
	}
}
