public class BookstoreApplication {
    public static void main(String[] args) throws BookNotFoundException {
        Bookstore bookstore = new Bookstore();
        bookstore.addBook(new Book("It ends with Us", "Colleen Hoover", 15.99));
        bookstore.addBook(new Book("Confess", "Colleen Hoover", 12.00));
        bookstore.addBook(new Book("Maybe Someday", "Colleen Hoover", 10.99));

        try {
            System.out.println("The book is found : " + bookstore.findBook("l"));
        } catch (BookNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}