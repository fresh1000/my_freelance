import java.io.IOException;
import java.util.Scanner;

public class BookcaseUI {

	public static Book readFromConsole() {
		Scanner sc = new Scanner(System.in);
		String ISBN;
		String author;
		String title;
		String publisher;
		int publicationYear;
		int publicationMonth;
		int publicationDay;
		int pageCount;
		System.out.print("Enter ISBN:");
		ISBN = sc.next();
		System.out.print("Enter author:");
		author = sc.next();
		System.out.print("Enter title:");
		title = sc.next();
		System.out.print("Enter publisher:");
		publisher = sc.next();
		System.out.print("Enter publication year:");
		publicationYear = sc.nextInt();
		System.out.print("Enter publication month:");
		publicationMonth = sc.nextInt();
		System.out.print("Enter publication day:");
		publicationDay = sc.nextInt();
		System.out.print("Enter page count:");
		pageCount = sc.nextInt();
		return new Book(ISBN, author, title, publisher, publicationYear, publicationMonth, publicationDay, pageCount);
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BookCase bookCase = new BookCase();
		int menuChoice = 0;
		boolean loop = true;
		while (loop) {
			System.out.println("1.Read from file.");
			System.out.println("2.Write to file");
			System.out.println("3.Add a book");
			System.out.println("4.Sort by ISBN");
			System.out.println("5.Delete by ISBN");
			System.out.println("6.Display the books");
			System.out.println("7.Clear bookcase list");
			System.out.println("8.Exit");

			menuChoice = sc.nextInt();

			switch (menuChoice) {
			case 1:
				bookCase.readFromFile();
				break;
			case 2:
				bookCase.writeToFile();
				break;
			case 3:
				bookCase.addBook(readFromConsole());
				break;
			case 4:
				bookCase.sortByISBN();
				break;
			case 5:
				String ISBN;
				System.out.print("Enter ISBN");
				ISBN = sc.next();
				bookCase.deleteBook(ISBN);
				break;
			case 6:
				System.out.println(bookCase.toString());
				break;
			case 7:
				bookCase.clearTheBookcase();
				break;
			case 8:
				loop = false;
				break;
			default:
				System.out.println("Invalid choice!");
				break;
			}
		}
	}

}
