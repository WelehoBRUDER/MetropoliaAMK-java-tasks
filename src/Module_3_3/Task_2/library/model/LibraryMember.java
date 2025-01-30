package Module_3_3.Task_2.library.model;

import java.util.ArrayList;

public class LibraryMember {
    private String name;
    private String id;
    private ArrayList<String> borrowedBooks;

    public LibraryMember(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(String bookId) {
        borrowedBooks.add(bookId);
    }
}
