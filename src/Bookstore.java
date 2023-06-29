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
        if (books.containsKey(book)) {
            books.put(book, books.get(book) + 1);

        } else {
            books.put(book, 1);
        }
    }

    public void addMultipleBooks(Book book, int quantity) {
        books.put(book, quantity);
    }

    public Book findBook(String title) throws BookNotFoundException {

        for (Book book : books.keySet()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        throw new BookNotFoundException("The book is not found! ");
    }

    public void displayBooks() {
        System.out.println("The books in the bookstore : ");
        for (Map.Entry<Book, Integer> entry : books.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue() + " pcs");
        }


    }

    public void sellBook(String title, int quantity) throws InsufficientStockException, BookNotFoundException {
        Book book = findBook(title);
        if (book == null) {
            throw new BookNotFoundException("Nincs ilyen könyv");
        }

        if (!books.containsKey(book) || books.get(book) < quantity) {
            throw new InsufficientStockException("Nincs elég készlet a könyvből");
        }

        books.replace(book, books.get(book) - quantity);
    }

}
