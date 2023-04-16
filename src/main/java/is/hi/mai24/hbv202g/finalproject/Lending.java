package is.hi.mai24.hbv202g.finalproject;

import java.time.LocalDate;

public class Lending {

    // Variables
    private LocalDate dueDate;
    private Book book;
    private User user;

    // Constructor
    public Lending(Book book, User user) {
        this.dueDate = LocalDate.now().plusDays(30);
        this.book = book;
        this.user = user;
    }

    // Getters and setters

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
