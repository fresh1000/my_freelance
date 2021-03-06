
public class Test {
	static void changeVar(int a) {
		a = 100;
	}

	static void changeObj(MyClass obj) {
		MyClass obj1 = new MyClass();
		obj1 = null;
		obj = obj1;
	}

	public static void main(String[] args) {
		int a = 0;
		MyClass obj = new MyClass();
		System.out.println(a);
		System.out.println(obj);

		changeVar(a);
		System.out.println(a);
		// we see that basic data type parameter is passed by value because it
		// hasn't changed after changing in the method

		changeObj(obj);
		System.out.println(obj);
		// we see that object is passed by reference because it has changed
		// after changing in the method
	}

}
