
public class Mammal {
	private boolean isMale = true;
	private String name = "Bayle";
	private int age = 0;
	private double weight = 0;

	public Mammal() {
		setAge(1);//set age to 1
	}

	public void grow() {
		weight++;//weight + 1
	}

	public void setSex(boolean isMale) {
		this.isMale = isMale;
	}

	public boolean getSex() {
		return isMale;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}
}
