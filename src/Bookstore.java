import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bookstore {

    private Map<Book, Integer> books;

    public Bookstore() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book, books.getOrDefault(book, 0) + 1);


    }

    public Book findBook(String title) throws BookNotFoundException {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equals(title)) {
                return book;
            }
        }

        throw new BookNotFoundException("The book is not found!");
    }

    public void displayBooks() {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            System.out.println("Book " + entry.getKey() +  ". Quantity : " + entry.getValue() + ".");
        }


    }

}
