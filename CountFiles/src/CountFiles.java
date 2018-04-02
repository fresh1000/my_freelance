import java.io.File;
import java.util.Scanner;

public class CountFiles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = "";
		System.out.print("Enter path(like 'e:/'): ");
		path = sc.nextLine();
		File selectedFolder = new File(path);
		File[] filesAll = selectedFolder.listFiles();
		int countFiles = 0;
		for (int i = 0; i < filesAll.length; i++) {
			if (filesAll[i].isFile()) {
				countFiles++;
			}
		}
		System.out.println("Count files in directory "+ path+" : " + countFiles);
	}
}
