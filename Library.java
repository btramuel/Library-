import java.util.*;

public class Library extends MainLibrary {
    private ArrayList<Book> books;
    private HashMap<String, Book> bookMap;

    public Library() {
        books = new ArrayList<>();
        bookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        bookMap.put(book.getTitle().toLowerCase(), book);
    }

    public void displayBooks() {
        System.out.println("Library Books (Unsorted):");
        for (Book book : books) {
            book.displayInfo();
            System.out.println();
        }
    }

    public void displayBooksSortedByTitle() {
        books.sort(Comparator.comparing(Book::getTitle));
        System.out.println("Library Books (Sorted by Title):");
        for (Book book : books) {
            book.displayInfo();
            System.out.println();
        }
    }

    public void displayBooksSortedByYear() {
        books.sort(Comparator.comparingInt(Book::getYear));
        System.out.println("Library Books (Sorted by Year):");
        for (Book book : books) {
            book.displayInfo();
            System.out.println();
        }
    }

    public void searchBook(String title) {
        Book book = bookMap.get(title.toLowerCase());
        if (book != null) {
            System.out.println("Book Found:");
            book.displayInfo();

            System.out.println("\nYou might also like books by the same author:");
            for (Book b : books) {
                if (b.getAuthor().equalsIgnoreCase(book.getAuthor()) && !b.getTitle().equalsIgnoreCase(title)) {
                    b.displayInfo();
                    System.out.println();
                }
            }
        } else {
            System.out.println("Book with title '" + title + "' not found in the library.");
        }
    }
}
