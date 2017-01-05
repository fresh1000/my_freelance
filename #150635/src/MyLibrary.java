import java.util.ArrayList;
import java.util.Scanner;

/*
This class creates and display Book objects 
taking into account class numbers of books.
*/
public class MyLibrary {
	public static int counterArray = 0;// counter length array
	
    public static void main(String[] args) {
        Book[] arrBook = new Book[100];//create array objects Book , max length = 100
    	int counter = 0;
        while (counter != 5) {
        	Book currentBook = getBookFromUser();
        	displayBook(currentBook);
        	
            if(currentBook.isChecked()) {
            arrBook[counterArray] = currentBook;//first element(object) add to array
            counterArray++;// counter length array + 1
            }
            counter++;
        }

        Book book1 = new Book("451","798","The Oxford English Grammar","Sidney Greenbaum",true);
        displayBook(book1);
        if (book1.isChecked()) {
        arrBook[counterArray] = book1;//add element(object) to array
        counterArray++;// counter length array + 1
        }
        Book book2 = new Book("205","488","Bible","Peter the apostle",true);
        displayBook(book2);
        if (book2.isChecked()) {
        arrBook[counterArray] = book2;//add element(object) to array
        counterArray++;// counter length array + 1
        }
        Book book3 = new Book("051","878","The Art of Computer Programming"," Donald Knuth",false);
        displayBook(book3);
        if (book3.isChecked()) {
        arrBook[counterArray] = book3;//add element(object) to array
        counterArray++;// counter length array + 1
        }
        Book book4 = new Book("4587","7981","Hamlet","William Shakespeare",true);
        displayBook(book4);
        if (book4.isChecked()) {
        arrBook[counterArray] = book4;//add element(object) to array
        counterArray++;// counter length array + 1
        }
        Book book5 = new Book("6489","8798","The History of the Decline and Fall of the Roman Empire","Edward Gibbon",true);
        displayBook(book5);
        if (book5.isChecked()) {
        arrBook[counterArray] = book5;//add element(object) to array
        counterArray++;// counter length array + 1
        }
        
        displayArrayBook(arrBook);//call method display Array books
    }
    /*
    Getting new book from input
    */
    private static Book getBookFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the class number: ");
        String classNumber = sc.nextLine();
        System.out.print("Enter the book number: ");
        String bookNumber = sc.nextLine();
        System.out.print("Enter the title: ");
        String title = sc.nextLine();
        System.out.print("Enter the author: ");
        String author = sc.nextLine();
        System.out.print("Is checked? (by default - Y) Y/N: ");
        String checked = sc.nextLine();
        boolean isChecked = true;
        if (checked.toLowerCase().equals("n"))
            isChecked = false;
        return new Book(classNumber, bookNumber, title, author, isChecked);
    }

    private static void displayBook(Book book) {
        System.out.println(book.getClassNumber() + "." + book.getBookNumber());
        System.out.println("Title: " + book.getTitle());
        System.out.println(getDesc(book.getClassNumber()));
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Checked? : " + book.isChecked() + "\n");
        System.out.println("Number of books : " + Book.bookCount);
        System.out.println("Number of checked books : " + Book.checkedCount + "\n");
    }
    
    private static void displayArrayBook(Book[] books) {
    	for (int i = 0; i < counterArray; i++) {
        	books[i].displayCheckedBook();//display checked book
        }
    	System.out.println();
    	System.out.println("Total books checked in: " + counterArray);
    }

    /*
    Convert class code into description
    */
    private static String getDesc(String classNumber) {
        int number = Integer.parseInt(classNumber);
        if (isBetween(number, 0, 100)) {
            return "General, Computer science and Information";
        } else if (isBetween(number, 100, 200)) {
            return "Philosophy and psychology";
        } else if (isBetween(number, 200, 300)) {
            return "Religion";
        } else if (isBetween(number, 300, 400)) {
            return "Social sciences";
        } else if (isBetween(number, 400, 500)) {
            return "Language";
        } else if (isBetween(number, 500, 600)) {
            return "Pure Science";
        } else if (isBetween(number, 600, 700)) {
            return "Technology";
        } else if (isBetween(number, 700, 800)) {
            return "Arts & recreation";
        } else if (isBetween(number, 800, 900)) {
            return "Literature";
        } else if (isBetween(number, 900, 1000)) {
            return "History & geography ";
        } else
            return "General, Computer science and Information";
    }
    /*
    Checking if value book between the range of lower and upper
    */
    private static boolean isBetween(int book, int lower, int upper) {
        return lower <= book && book < upper;
    }
}