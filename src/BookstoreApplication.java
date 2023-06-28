public class BookstoreApplication {
    public static void main(String[] args) throws BookNotFoundException {
        Bookstore bookstore = new Bookstore();
        bookstore.addBook(new Book("It ends with Us", "Colleen Hoover", 15.99));
        bookstore.addBook(new Book("It ends with Us", "Colleen Hoover", 15.99));
        bookstore.addBook(new Book("Confess", "Colleen Hoover", 12.00));
        bookstore.addBook(new Book("Maybe Someday", "Colleen Hoover", 10.99));


        try {
            System.out.println("The book is found : " + bookstore.findBook("l"));
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            bookstore.sellBook("Confess", 1);
            bookstore.sellBook("Maybe Someday", 1);
            bookstore.sellBook("It end with Us", 1);

        } catch (InsufficientStockException | BookNotFoundException e) {
            System.out.println(e.getMessage());
        }

        bookstore.displayBooks();


    }
}