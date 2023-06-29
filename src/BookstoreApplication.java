
public class BookstoreApplication {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        bookstore.addBook(new Book("It ends with Us", "Colleen Hoover", 15.99));
        bookstore.addBook(new Book("Confess", "Colleen Hoover", 12.00));
        bookstore.addBook(new Book("Maybe Someday", "Colleen Hoover", 10.99));

        try {
            Book book = bookstore.findBook("l");
            if (book != null) {
                System.out.println(book);
            } else {
                System.out.println("Nincs ilyen könyv");
            }
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            bookstore.sellBook("Confess", 1);
            bookstore.sellBook("Maybe Someday", 1);
            bookstore.sellBook("It ends with Us", 1);
        } catch (InsufficientStockException | BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        bookstore.displayBooks();
    }
}
