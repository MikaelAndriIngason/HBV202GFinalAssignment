package is.hi.mai24.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {

    private Author author;

    @Before
    public void setUp() {
        author = new Author("John Doe");
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", author.getName());
    }

    @Test
    public void testSetName() {
        author.setName("Jane Doe");
        assertEquals("Jane Doe", author.getName());
    }
}
