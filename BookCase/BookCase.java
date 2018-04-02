import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BookCase {
	private ArrayList<Book> books = new ArrayList<>();
	private int bookCount = 0;
	
	public void addBook(Book book) {
		books.add(book);
		bookCount++;
	}
	
	public void search(String ISBN) {
		boolean found = false;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getISBN().equals(ISBN)) {
				found = true;
				System.out.println("Found:");
				System.out.println(books.get(i).toString());
			}
		}
		if(!found) {
			System.out.println("Not found!");
		}
	}
	
	public void clearTheBookcase() {
		books.clear();
	}
	
	
	public ArrayList<Book> getBooks() {
		return books;
	}

	public void deleteBook(String ISBN) {
		boolean foundDelBook = false;
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getISBN().equals(ISBN)) {
				books.remove(i);
				foundDelBook = true;
			}
		}
		if(!foundDelBook) {
			System.out.println("Not found!");
		}
	}
	
	public void sortByISBN() {
		Collections.sort(books);
	}
	
	public void readFromFile() throws IOException {
		File file1 = new File("Books.txt");
		FileReader file = new FileReader(file1);
		Scanner input = new Scanner(file);
		if (!file1.exists()) {
			file1.createNewFile();
		} else {
			// variables for all informations read from file
			String line;
			String[] lineVec;
			String ISBN;
			String author;
			String title;
			String publisher;
			int publicationYear;
			int publicationMonth;
			int publicationDay;
			int pageCount;
			
			while (input.hasNextLine()) {
				line = input.nextLine();
				lineVec = line.split(",");
				ISBN = lineVec[0];
				author = lineVec[1];
				title = lineVec[2];
				publisher = lineVec[3];
				publicationYear = Integer.parseInt(lineVec[4]);
				publicationMonth = Integer.parseInt(lineVec[5]);
				publicationDay = Integer.parseInt(lineVec[6]);
				pageCount = Integer.parseInt(lineVec[7]);
				books.add(new Book(ISBN, author, title, publisher, publicationYear, publicationMonth, publicationDay, pageCount));
				bookCount++;
			}
		}
		input.close();
	}
	
	public void writeToFile() throws IOException {
		FileWriter writer = new FileWriter("Books.txt");
		if (books != null) {
			for (int i = 0; i < books.size(); i++) {
				writer.write(books.get(i).toString());
				writer.append("\n");
			}
			writer.flush();
			writer.close();
		}
	}

	public String toString() {
		String booksStr = "";
		for (Book book: books) {
			booksStr += book.toString() + "\n";
		}
		return booksStr;
	}
	
}
