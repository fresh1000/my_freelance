import java.lang.reflect.*;
import java.util.Vector;

public class Testeee {

	public static void main(String[] args) {
		try {
			Vector c1 = new Vector();
			Class cls1 = Vector.class;
			Method mAdd = cls1.getMethod("add", Object.class);
			mAdd.setAccessible(true);
			Double a = new Double(12.32);
			mAdd.invoke(c1, a);
			System.out.println(c1.toString());
			Method mStr = cls1.getMethod("toString");
			System.out.println(mStr.invoke(c1, null));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}