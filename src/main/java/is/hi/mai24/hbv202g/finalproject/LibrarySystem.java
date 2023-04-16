package is.hi.mai24.hbv202g.finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    // Variables
    private List<Book> books;
    private List<User> users;
    private List<Lending> lendings;

    // Constructor
    public LibrarySystem() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
        this.lendings = new ArrayList<>();
    }

    // Add a book to the library
    public void addBookWithTitleAndAuthorlist(String title, List<Author> authors) throws EmptyAuthorListException {
        Book book = new Book(title, authors);
        books.add(book);
    }

    // Add a user to the library
    public void addStudentUser(String name, boolean feePaid) {
        User user = new Student(name, feePaid);
        users.add(user);
    }

    // Add a faculty member to the library
    public void addFacultyMember(String name, String department) {
        User user = new FacultyMember(name, department);
        users.add(user);
    }

    // Find a book in the library by title
    public Book findBookByTitle(String title) throws UserOrBookDoesNotExistException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new UserOrBookDoesNotExistException("Book does not exist");
    }

    // Find a user in the library by name
    public User findUserByName(String name) throws UserOrBookDoesNotExistException {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        throw new UserOrBookDoesNotExistException("User does not exist");
    }

    // Borrow a book from the library
    public void borrowBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (!users.contains(user) || !books.contains(book)) {
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }

        Lending lending = new Lending(book, user);
        lendings.add(lending);
    }

    // Extend the due date of a book
    public void extendLending(FacultyMember facultyMember, Book book, LocalDate newDueDate) throws UserOrBookDoesNotExistException {
        if (!users.contains(facultyMember) || !books.contains(book)) {
            throw new UserOrBookDoesNotExistException("Faculty member or book does not exist");
        }

        boolean found = false;
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(facultyMember)) {
                lending.setDueDate(newDueDate);
                found = true;
            }
        }

        if (!found) {
            throw new UserOrBookDoesNotExistException("Lending does not exist");
        }
    }

    // Return a book to the library
    public void returnBook(User user, Book book) throws UserOrBookDoesNotExistException {
        if (!users.contains(user) || !books.contains(book)) {
            throw new UserOrBookDoesNotExistException("User or book does not exist");
        }

        boolean returned = false;
        for (Lending lending : lendings) {
            if (lending.getBook().equals(book) && lending.getUser().equals(user)) {
                lendings.remove(lending);
                returned = true;
            }
        }

        if (!returned) {
            throw new UserOrBookDoesNotExistException("Lending does not exist");
        }
    }
}
