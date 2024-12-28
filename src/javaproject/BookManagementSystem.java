package javaproject;


class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookID, String title, String author, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "BookID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}

class Library {
    private Book[] books;
    private int bookCount;

    public Library() {
        this.books = new Book[5]; // Maximum capacity of 5 books
        this.bookCount = 0;
    }

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void removeBook(int bookID) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookID() == bookID) {
                books[i] = books[bookCount - 1]; // Replace with the last book
                books[--bookCount] = null; // Reduce count and set the last slot to null
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void searchBook(int bookID) {
        for (Book book : books) {
            if (book != null && book.getBookID() == bookID) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books in the library.");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }
}

public class BookManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book(1, "Java Programming", "James Gosling", true));
        library.addBook(new Book(2, "Data Structures", "Mark Allen", true));

        // Displaying books
        System.out.println("\nDisplaying all books:");
        library.displayBooks();

        // Searching for a book
        System.out.println("\nSearching for Book with ID 1:");
        library.searchBook(1);

        // Removing a book
        System.out.println("\nRemoving Book with ID 2:");
        library.removeBook(2);

        // Displaying books after removal
        System.out.println("\nDisplaying all books:");
        library.displayBooks();
    }
}