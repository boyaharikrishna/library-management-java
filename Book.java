package ArrayList;

import java.util.Scanner;
import java.util.ArrayList;
public class Book {
    String title;
    String author;
    int id;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added successfully!\n");
    }

    void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.\n");
            return;
        }
        for (Book b : books) {
            b.display();
        }
        System.out.println();
    }

    void searchBook(String title) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.\n");
        }
    }

    void deleteBook(int id) {
        boolean removed = books.removeIf(book -> book.id == id);
        if (removed) {
            System.out.println("Book deleted successfully.\n");
        } else {
            System.out.println("Book not found with ID: " + id + "\n");
        }
    }
}


class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book by Title");
            System.out.println("4. Delete Book by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();
                    Book b = new Book(id, title, author);
                    library.addBook(b);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    System.out.print("Enter title to search: ");
                    String searchTitle = sc.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 4:
                    System.out.print("Enter Book ID to delete: ");
                    int deleteId = sc.nextInt();
                    library.deleteBook(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}
