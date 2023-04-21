package is.hi.mai24.hbv202g.finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {
    // Variables
    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    /**
     * LibrarySystem constructor (creates a new library system).
     */
    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    /**
     * Add a new book to the library.
     * @param title book's title
     * @param authors book's authors
     * @throws EmptyAuthorListException
     */
    public void addBookWithTitleAndAuthorlist(String title, List<Author> authors) throws EmptyAuthorListException {
        Book book = new Book(title, authors);
        books.add(book);
    }

    /**
     * Adds a new user to the library.
     * @param name student's name
     * @param password student's password
     * @param feePaid has the student paid the fee?
     */
    public void addStudentUser(String name, String password, boolean feePaid) {
        User user = new Student(name, password, feePaid);
        users.add(user);
    }

    /**
     * Adds a new faculty member to the library.
     * @param name faculty member's name
     * @param password faculty member's password
     * @param department faculty member's department
     */
    public void addFacultyMember(String name, String password, String department) {
        User user = new FacultyMember(name, password, department);
        users.add(user);
    }

    /**
     * Finds a book by its title, if it exists.
     * @param title book's title
     * @return book that matches the title
     * @throws UserOrBookDoesNotExistException
     */
    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book does not exist");
    }

    /**
     * Finds a user by its name, if they exist.
     * @param name user's name
     * @return user that matches the name
     * @throws UserOrBookDoesNotExistException
     */
    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserOrBookDoesNotExistException("User does not exist");
    }

    /**
     * Lends a book to a user.
     * @param user user to lend the book to
     * @param book book to lend
     * @throws UserOrBookDoesNotExistException
     */
    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (!users.contains(user) || !books.contains(book)) {
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }

        boolean isLent = false;
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book)) {
                isLent = true;
                throw new UserOrBookDoesNotExistException("Book not available, already borrowed");
            }
        }

        if (!isLent) {
            Lending lending = new Lending(book, user);
            lendings.add(lending);
        }
    }

    /**
     * Extends a user's lending period.
     * @param book book to extend
     * @param newDueDate new due date
     * @throws UserOrBookDoesNotExistException
     */
    public void extendLending(Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
        if (!books.contains(book)) {
            throw new UserOrBookDoesNotExistException("Book does not exist");
        }

        boolean found = false;
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book)) {
                lending.setDueDate(newDueDate);
                found = true;
            }
        }

        if (!found) {
            throw new UserOrBookDoesNotExistException("Lending does not exist");
        }
    }

    /**
     * Returns a book to the library.
     * @param user user that is returning the book
     * @param book book to return
     * @throws UserOrBookDoesNotExistException
     */
    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (!users.contains(user) || !books.contains(book)) {
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }

        boolean returned = false;
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(user)) {
                lendings.remove(lending);
                returned = true;
                break;
            }
        }

        if (!returned) {
            throw new UserOrBookDoesNotExistException("Lending does not exist");
        }
    }
}
