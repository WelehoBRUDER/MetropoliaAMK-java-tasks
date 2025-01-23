package Module_2_3.Task_2;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, int year) {
        books.add(new Book(title, author, year));
    }

    public void displayBooks() {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.displayInfo());
        }
    }

    public void displayBooks(ArrayList<Book> bookSet) {
        for (int i = 0; i < bookSet.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i).getOnlyBookInfo());
        }

    }

    public Book borrowBook(String title) {
        Book book = null;
        for (int i = 0; i < books.size(); i++) {
            Book book1 = books.get(i);
            if (book1.getTitle().equals(title)) {
                book = book1;
                books.remove(i);
                break;
            }
        }
        return book;
    }

    public void returnBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooksByAuthor(String author) {
        ArrayList<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().contains(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }
}
