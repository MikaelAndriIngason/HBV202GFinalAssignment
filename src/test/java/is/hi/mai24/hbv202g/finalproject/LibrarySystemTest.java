package is.hi.mai24.hbv202g.finalproject;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LibrarySystemTest {

    private LibrarySystem librarySystem;

    @Before
    public void setUp() throws EmptyAuthorListException{
        librarySystem = new LibrarySystem();

        librarySystem.addStudentUser("Bob", "111", false);
        librarySystem.addBookWithTitleAndAuthorlist("Harry Potter", Arrays.asList(new Author("J.K. Rowling")));
    }

    @Test
    public void testAddBookWithTitleAndAuthorlist() throws EmptyAuthorListException {
        List<Author> authors = new ArrayList<>(Arrays.asList(new Author("George R.R. Martin")));
        librarySystem.addBookWithTitleAndAuthorlist("Game of Thrones", authors);
    }

    @Test
    public void testAddStudentUser() {
        librarySystem.addStudentUser("Mikael Andri Ingason", "321", true);
    }

    @Test
    public void testAddFacultyMember() {
        librarySystem.addFacultyMember("John Doe the Third", "3", "Computer Science");
    }

    @Test
    public void testFindBookByTitle() throws UserOrBookDoesNotExistException {
        librarySystem.findBookByTitle("Harry Potter");
    }

    @Test
    public void testFindUserByName() throws UserOrBookDoesNotExistException {
        librarySystem.findUserByName("Bob");
    }

    @Test
    public void testBorrowBook() throws UserOrBookDoesNotExistException {
        User user = librarySystem.findUserByName("Bob");
        librarySystem.borrowBook(user, librarySystem.findBookByTitle("Harry Potter"));
    }

    @Test
    public void testExtendLending() throws UserOrBookDoesNotExistException {
        User user = librarySystem.findUserByName("Bob");
        librarySystem.borrowBook(user, librarySystem.findBookByTitle("Harry Potter"));
        librarySystem.extendLending(librarySystem.findBookByTitle("Harry Potter"), LocalDate.now().plusDays(30));
    }

    @Test
    public void testReturnBook() throws UserOrBookDoesNotExistException  {
        User user = librarySystem.findUserByName("Bob");
        librarySystem.borrowBook(user, librarySystem.findBookByTitle("Harry Potter"));
        librarySystem.returnBook(user, librarySystem.findBookByTitle("Harry Potter"));
    }
}
