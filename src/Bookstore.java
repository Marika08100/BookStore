import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bookstore {

    private final Map<Book, Integer> books;

    public Bookstore() {
        this.books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book,1);
    }
    public void addBookWithQuantity(Book book,int howMany){
        books.put(book,howMany);
    }

    public Book findBook(String title) throws BookNotFoundException {
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            Book book = entry.getKey();
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        throw new BookNotFoundException("The book is not found!");
    }

    public void displayBooks() {
        System.out.println("The books in the bookstore : ");
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            System.out.println("Book " + entry.getKey() + ". Quantity : " + entry.getValue() + ".");
        }


    }

    public void sellBook(String title, int quantity) throws InsufficientStockException, BookNotFoundException {
        Book book = findBook(title);
        int availableQ = books.getOrDefault(book, 0);
        if (availableQ > 0 && availableQ >= quantity) {
            books.put(book, availableQ - quantity);
        }else{
            throw new InsufficientStockException("Insufficient stock for book: " + title);
        }
    }

}
