package is.hi.mai24.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
public class LendingTest {

    private Lending lending;

    @Before
    public void setUp() throws EmptyAuthorListException {
        Book book = new Book("The Hobbit", new ArrayList<>(Arrays.asList(new Author("J.R.R. Tolkien"))));
        User user = new User("Mikael Andri Ingason", "321");
        lending = new Lending(book, user);
    }

    @Test
    public void testGetDueDate() {
        assertEquals(LocalDate.now().plusDays(30), lending.getDueDate());
    }

    @Test
    public void testSetDueDate() {
        LocalDate dueDate = LocalDate.now().plusDays(90);
        lending.setDueDate(dueDate);
        assertEquals(dueDate, lending.getDueDate());
    }

    @Test
    public void testSetBook() throws EmptyAuthorListException {
        Book book = new Book("The Lord of the Rings", new ArrayList<>(Arrays.asList(new Author("J.R.R. Tolkien"))));
        lending.setBook(book);
        assertEquals(book, lending.getBook());
    }

    @Test
    public void testSetUser() {
        User user = new User("Bob", "777");
        lending.setUser(user);
        assertEquals(user, lending.getUser());
    }

}
