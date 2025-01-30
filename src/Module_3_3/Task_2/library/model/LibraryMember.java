package Module_3_3.Task_2.library.model;

import java.util.ArrayList;

public class LibraryMember {
    private String name;
    private int id;
    private ArrayList<String> borrowedBooks;
    private static int totalMembers = 0;

    public LibraryMember(String name) {
        this.name = name;
        this.id = totalMembers;
        this.borrowedBooks = new ArrayList<>();
        totalMembers++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean hasBook(String bookId) {
        return borrowedBooks.contains(bookId);
    }

    public void borrowBook(String bookId) {
        if (!hasBook(bookId)) {
            borrowedBooks.add(bookId);
        }
    }

    public boolean returnBook(String bookId) {
        if (hasBook(bookId)) {
            borrowedBooks.remove(bookId);
            return true;
        }
        return false;
    }
}
