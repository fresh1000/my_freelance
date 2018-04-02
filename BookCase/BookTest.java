import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookTest
{
    /**
     * Default constructor for test class BookTest
     */
    public BookTest()
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
    public void testGetAuthor()
    {
        Book book1 = new Book("123-123-123", "Bill", "Sea", "ARAW", 2015, 10, 12, 235);
        assertEquals("Bill", book1.getAuthor());
    }

    @Test
    public void testGetISBN()
    {
        Book book1 = new Book("123-123-123", "Bill", "Sea", "ARAW", 2015, 10, 12, 235);
        assertEquals("123-123-123", book1.getISBN());
    }

    @Test
    public void testGetTitle()
    {
        Book book1 = new Book("123-123-123", "Bill", "Sea", "ARAW", 2015, 10, 12, 235);
        assertEquals("Sea", book1.getTitle());
    }

    @Test
    public void testGetYear()
    {
        Book book1 = new Book("123-123-123", "Bill", "Sea", "ARAW", 2015, 10, 12, 235);
        assertEquals(2015, book1.getPublicationYear());
    }
    
    @Test
    public void testGetMonth()
    {
        Book book1 = new Book("123-123-123", "Bill", "Sea", "ARAW", 2015, 10, 12, 235);
        assertEquals(10, book1.getPublicationMonth());
    }
    
    @Test
    public void testGetDay()
    {
        Book book1 = new Book("123-123-123", "Bill", "Sea", "ARAW", 2015, 10, 12, 235);
        assertEquals(12, book1.getPublicationDay());
    }
    
}





