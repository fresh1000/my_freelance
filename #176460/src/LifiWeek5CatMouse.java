import java.util.ArrayList;

public class LifiWeek5CatMouse {

	public static void main(String[] args) {
		Cat cat = new Cat();// instance of Cat
		cat.setName("RULE");//set cat name
		ArrayList<Mouse> mouses = new ArrayList<>();// ArrayList mouses

		// create instance all mouses
		Mouse mouse1 = new Mouse();
		Mouse mouse2 = new Mouse();
		Mouse mouse3 = new Mouse();

		// setSex for all mouses
		mouse1.setSex(true);
		mouse2.setSex(false);
		mouse3.setSex(false);

		// set names mouses
		mouse1.setName("Drool");
		mouse2.setName("Drool2");
		mouse3.setName("Drool3");

		// add mouse to ArrayList
		mouses.add(mouse1);
		mouses.add(mouse2);

		//while ArrayList mouses not 0  
		while (mouses.size() != 0) {
			for (int i = 0; i < mouses.size(); i++) {
				mouses.get(i).grow();//grow all mouses
			}
			cat.grow();//grow cat
			Mouse.mate(mouses);//mate mouses
			cat.eat(mouses);//eat mouses
		}
		System.out.println("Cats " + cat.getName() + ", Mice " + mouse1.getName() + "!");
		System.out.println("Cat Weight (in mice): " + cat.getWeight());

	}

}
