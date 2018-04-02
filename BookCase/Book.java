public class Book implements Quotable, Comparable<Book>{

	private String ISBN;
	private String author;
	private String title;
	private String publisher;
	private int publicationYear;
	private int publicationMonth;
	private int publicationDay;
	private int pageCount;
	
	
	
	public Book(String iSBN, String author, String title, String publisher, int publicationYear, int publicationMonth,
			int publicationDay, int pageCount) {
		ISBN = iSBN;
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.publicationYear = publicationYear;
		this.publicationMonth = publicationMonth;
		this.publicationDay = publicationDay;
		this.pageCount = pageCount;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}
	
	public String getPublisher() {
		return publisher;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public int getPublicationMonth() {
		return publicationMonth;
	}

	public int getPublicationDay() {
		return publicationDay;
	}

	public int getPageCount() {
		return pageCount;
	}
	
	public int compareTo(Book o) {
        return ISBN.compareTo(o.ISBN);
    }

	public String toString() {
		return ISBN + "," + author + "," + title + "," + publisher
				+ "," + publicationYear + "," + publicationMonth
				+ "," + publicationDay + "," + pageCount;
	}

}
