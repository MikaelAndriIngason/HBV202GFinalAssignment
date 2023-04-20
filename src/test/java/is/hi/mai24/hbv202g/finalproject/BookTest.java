package is.hi.mai24.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void setUp() throws EmptyAuthorListException {
        book = new Book("The Hobbit", new ArrayList<>(Arrays.asList(new Author("J.R.R. Tolkien"))));
    }

    @Test
    public void testGetAuthors() {
        assertEquals(1, book.getAuthors().size());
    }

    @Test
    public void testAddAuthor() {
        Author author = new Author("George R.R. Martin");
        book.addAuthor(author);
        assertEquals(2, book.getAuthors().size());
    }

    @Test
    public void testSetAuthors() {
        List<Author> authors = new ArrayList<>(Arrays.asList(new Author("John Doe"), new Author("Jane Doe")));
        book.setAuthors(authors);
        assertEquals(2, book.getAuthors().size());
    }

    @Test
    public void testGetTitle() {
        assertEquals("The Hobbit", book.getTitle());
    }

    @Test
    public void testSetTitle() {
        book.setTitle("The Lord of the Rings");
        assertEquals("The Lord of the Rings", book.getTitle());
    }
}
