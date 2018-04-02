import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;

public class BookCaseTest
{
    /**
     * Default constructor for test class BookCaseTest
     */
    public BookCaseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }


    @Test
    public void testClearList() throws IOException
    {
        BookCase bookCase1 = new BookCase();
        bookCase1.readFromFile();
        bookCase1.clearTheBookcase();
        assertEquals("", bookCase1.toString());
    }
    
    @Test
    public void testAdd() {
        Book book1 = new Book("123-123-123", "Bill", "Sea", "ARAW", 2015, 10, 12, 235);
        BookCase c = new BookCase();
        c.addBook(book1);
        assertNotSame("", c.toString());
    }

    @Test
    public void testGetBooks() throws IOException
    {
        BookCase bookCase1 = new BookCase();
        bookCase1.readFromFile();
        assertNotNull(bookCase1.getBooks());
    }
}



