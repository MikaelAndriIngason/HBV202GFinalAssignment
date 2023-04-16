import java.util.ArrayList;
import java.util.List;

public class Book {

    // Variables
    private String title;
    private List<Author> authors;

    // Constructor
    public Book(String title, List<Author> authors) throws EmptyAuthorListException {
        //if (authors.size() == 0)
        //    throw new EmptyAuthorListException("Author list is empty");
        super();
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
