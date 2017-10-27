
import java.util.ArrayList;

public class Cat extends Mammal {
	public void grow() {
		setAge(getAge() + 1);//set age + 1
	}

	public void eat(ArrayList<Mouse> inMice) {
		int index = (int) (Math.random() * 10) % inMice.size();//get random index
		
		if ((int) (Math.random() * 10) <= 7) {
			setWeight(getWeight() + inMice.get(index).getWeight());//add weight mouse to cat
			inMice.remove(index);//remove this mouse from array
		}

	}

}
