import java.util.Scanner;

public class TestTriangle {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);// scan input
		try {
		while (in.hasNextInt()) {// while input has int
		int a = in.nextInt();// input side 1
		int b = in.nextInt();//input side 2
		int c = in.nextInt();//input side 3
		TriangleAnalyzer triangle = new TriangleAnalyzer(a, b, c);//create object TriangleAnalyzer 
		System.out.println();
		System.out.println(triangle.getLength1() + " " + triangle.getLength2() + " " + triangle.getLength3());//print all sides
		System.out.println(triangle.typeTriangle());//print type triangle
		if(triangle.typeTriangle() != "Not triangle"){//if type triangle not equals "Not triangle"
			System.out.println(triangle.areaTriangle());//print area triangle
		}
		System.out.println();
		}
		}finally {
			in.close();
		}
	}

}
