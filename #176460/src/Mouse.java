
import java.util.ArrayList;

public class Mouse extends Mammal {

	public Mouse() {
		setAge(1);//set age
		setWeight(1);//set weight
		setSex((Math.random() * 10 > 5) ? true : false);//setSex
	}

	public void grow() {
		setAge(getAge() + 1);//set new age
		setWeight(getWeight() * 1.01);//set new weight
	}

	public static void mate(ArrayList<Mouse> inMice) {
		int random1 = (int) (Math.random() * 10) % (inMice.size());//random1 index
		int random2 = (int) (Math.random() * 10) % (inMice.size());//random2 index
		//if random1 and random2 getSex not equals
		if (inMice.get(random1).getSex() != inMice.get(random2).getSex()) {
			//if age random1 and random2 greater than 1
			if (inMice.get(random1).getAge() > 1 && inMice.get(random2).getAge() > 1) {
				for (int count = 0; count < (Math.random() * 10) % 4; count++) {
					inMice.add(new Mouse());//add new Mouse
				}
			}
		}

	}

}
