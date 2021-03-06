package part1;

import java.util.Scanner;

public class Library {

	public static void main(String[] args) {
		Book book1 = new Book();//create object book1
		book1.title = "Harry Potter and the Sorceror�s Stone";//set title
		book1.setAuthor("J.K. Rowling");//set author, use mutator because author is private
		book1.pubYear = 1997;//set year
		book1.description();//print description book1
		
		Book book2 = new Book();//create object book2
		book2.setTitle("Cloudy with a Chance of Meatballs");//set title
		book2.setGenre("Children�s");//set genre
		book2.setPubYear(1978);//set year
		book2.description();//print description book2
		
		Book book3 = new Book();//create object book3
		Scanner sc = new Scanner(System.in);//scanner for read from console
		
		System.out.print("Enter author:");
		String author = sc.next();//read from console
		book3.setAuthor(author);//set author
		
		System.out.print("Enter title:");
		String title = sc.next();//read from console
		book3.title = title;//set title
		
		System.out.print("Enter genre:");
		String genre = sc.next();//read from console
		book3.genre = genre;//set genre
		
		System.out.print("Enter publication year:");
		int year = sc.nextInt();//read from console
		book3.pubYear = year;//set year
		
		System.out.print("Enter paperback(true/false):");
		boolean paper = sc.nextBoolean();//read from console
		book3.isPaperback = paper;//set paperback
		
		book3.description();//print description book3
		
		System.out.println("I read " + Book.getBooksRead() + " books");//print read books
	
	}

}
