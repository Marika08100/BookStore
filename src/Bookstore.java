import java.util.ArrayList;
import java.util.List;

public class Bookstore {

    private List<Book> books;

    public Bookstore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);

    }

    public Book findBook(String title) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        throw new BookNotFoundException("The book is not found!");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }

    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Bookstore{" +
                "books=" + books +
                '}';
    }
}
