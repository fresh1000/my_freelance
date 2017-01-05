
class Book {
    private String classNumber;
    private String bookNumber;
    private String title;
    private String author;
    private boolean isChecked;
    
    public static int bookCount = 0;
    public static int checkedCount = 0;

    public Book() {
        this.classNumber = "000";
        this.bookNumber = "000";
        this.title = "Book Title";
        this.author = "Doe, John";
        this.isChecked = true;
        bookCount++;
        checkedCount++;

    }

    public Book(String classNumber, String bookNumber, String title, String author, boolean isChecked) {
        if (Integer.parseInt(classNumber) > 0 && Integer.parseInt(classNumber) < 1000) {
            this.classNumber = classNumber;
        } else
            this.classNumber = "000";
        if (Integer.parseInt(bookNumber) > 0 && Integer.parseInt(bookNumber) < 1000) {
            this.bookNumber = classNumber;
        } else
            this.bookNumber = "000";
        this.title = title;
        this.author = author;
        this.isChecked = isChecked;
        bookCount++;
        if (isChecked)
            checkedCount++;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    
    public void displayCheckedBook() {
    	if(isChecked == true) {
    		System.out.println(title + ", by " + author);
    	}
    }
}
