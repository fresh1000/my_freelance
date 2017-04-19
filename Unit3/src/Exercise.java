
public class Exercise {

	public static void main(String[] args) {
		// 3.0
		System.out.println("3.0)");
		String[] car = { "Chrysler", "Ford", "Toyota" };
		for (String in : car) {
			System.out.println(in);
		}
		System.out.println();

		// 3.1
		System.out.println("3.1)");
		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		System.out.println("Forwards:");
		for (int i = 0; i < days.length; i++) {
			System.out.println(days[i]);
		}
		System.out.println();
		System.out.println("Backwards:");
		for (int i = days.length - 1; i >= 0; i--) {
			System.out.println(days[i]);
		}

		// 3.2
		System.out.println();
		System.out.println("3.2)");
		int[] arr = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Element at index " + i + ": " + arr[i]);
		}

		// 3.3
		// int k = arr[11]; Error "ArrayIndexOutOfBoundsException" because arr
		// don't have 12 element

		// 3.4
		System.out.println();
		System.out.println("3.4)");
		String[][] grades = { { "Ron", "A", "B", "A", "B" }, { "Bob", "B", "B", "C", "B" },
				{ "Craig", "C", "C", "B", "C" } };
		
		System.out.println("Result by test number:");
		System.out.println("1 test: " + grades[0][1] + grades[1][1] + grades[2][1]);
		System.out.println("2 test: " + grades[0][2] + grades[1][2] + grades[2][2]);
		System.out.println("3 test: " + grades[0][3] + grades[1][3] + grades[2][3]);
		System.out.println("4 test: " + grades[0][4] + grades[1][4] + grades[2][4]);
		System.out.println();
		System.out.println("Result by student number:");
		for (int i = 0; i < grades.length; i++) {
			for (int j = 0; j < grades[i].length; j++) {
				if (j == 1 || j == 2 || j == 3 || j == 4) {
					System.out.print(grades[i][j] + " ");
				}
				if (j == 4) {
					System.out.println();
				}
			}
		}
		
		System.out.println("Students Name:");
		for (int i = 0; i < grades.length; i++) {
			System.out.println(grades[i][0]);
		}
	}

}
