import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		int rows = 0;
		Scanner sc = new Scanner(System.in);
		String line = null;
		while (rows < 1 || rows > 13) {
			System.out.print("Enter number of rows:");
			line = sc.nextLine();
			if (line.matches("-?\\d+")) {//regular expression check integer in string
				rows = Integer.parseInt(line);//parse integer in string
				if (rows > 13 || rows < 1) {
					System.out.println("Try again!(Only integers in range from 1 to 13)");
				}
			} else {
				System.out.println("Try again!(Only integers)");
			}
		}
		
		PascalsTriangle triangle = new PascalsTriangle(rows);//create instance PascalsTriangle type
		System.out.println(triangle.toString());//print toString method
	}

}
