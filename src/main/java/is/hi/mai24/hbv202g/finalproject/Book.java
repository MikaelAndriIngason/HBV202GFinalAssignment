package is.hi.mai24.hbv202g.finalproject;

import java.util.List;

public class Book {
    // Variables
    private String title;
    private List<Author> authors;

    /**
     * Book constructor (creates a new book).
     * @param title book's title
     * @param authors book's authors
     * @throws EmptyAuthorListException
     */
    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        if (authors.size() == 0)
            throw new EmptyAuthorListException("Author list is empty");
        this.title = title;
        this.authors = authors;
    }

    // Getters and setters

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
