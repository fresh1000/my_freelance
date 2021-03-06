package part1;

public class Book {
	private String author;
	public String title;
	public int pubYear;
	public String genre;
	private static int booksRead = 0;
	public boolean isPaperback = false;
	
	public Book() {
		this.genre = "fiction";
		booksRead++;
	}
	/*
	 * Method print description
	 */
	public void description() {
		String paperback = "";
		if(isPaperback) {
			paperback = "Paperback";
		}else
			paperback = "Hardcover";
		System.out.println("Title: " + getTitle() + "\n" +" Author: " + getAuthor() + "\n" +
			" Genre: " + getGenre() + "\n" +" Year: " + getPubYear() + "\n" + " Book Material:" +
				paperback);
	}
	
	/*
	 * Getters methods
	 */
	public String getAuthor() {
		return author;
	}
	public String getTitle() {
		return title;
	}
	public int getPubYear() {
		return pubYear;
	}
	public String getGenre() {
		return genre;
	}
	public static int getBooksRead() {
		return booksRead;
	}
	public boolean isPaperback() {
		return isPaperback;
	}
	/*
	 * Setters methods
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public static void setBooksRead(int booksRead) {
		Book.booksRead = booksRead;
	}
	public void setPaperback(boolean isPaperback) {
		this.isPaperback = isPaperback;
	}
	
}
