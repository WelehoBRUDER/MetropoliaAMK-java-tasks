package Module_2_3.Task_1;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, int year) {
        books.add(new Book(title, author, year));
        books.get(books.size() - 1).setIndex(books.size() - 1);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println((book.getIndex() + 1) + ". " + book.displayInfo());
        }
    }

    public void displayBooks(ArrayList<Book> bookSet) {
        int index = 1;
        for (Book book : bookSet) {
            System.out.println(index + ". " + book.getOnlyBookInfo());
            index++;
        }
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
