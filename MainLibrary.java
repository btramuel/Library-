import java.util.Scanner;
class MainLibrary {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("Diary of a Wimpy Kid", "Jeff Kinney", 2007));
        library.addBook(new Book("The Adventures of Captain Underpants", "Dav Pilkey", 1997));
        library.addBook(new Book("Percy Jackson and the Olympians The Lighting Thief", "Rick Riordan", 2005));
        library.addBook(new Book("No, David!", "David Shannon", 1998));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library!");
        System.out.println("Enter 1 to display all books, 2 to display books sorted by title, 3 to display books sorted by year, 4 to search for a book by title, or 0 to exit.");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        while (choice != 0) {
            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.displayBooksSortedByTitle();
                    break;
                case 3:
                    library.displayBooksSortedByYear();
                    break;
                case 4:
                    System.out.print("Enter the title of the book to search: ");
                    String title = scanner.nextLine();
                    library.searchBook(title);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println("\nEnter 1 to display all books, 2 to display books sorted by title, 3 to display books sorted by year, 4 to search for a book by title, or 0 to exit.");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
        }

        scanner.close();
        System.out.println("Exiting Library. Goodbye!");
    }
}