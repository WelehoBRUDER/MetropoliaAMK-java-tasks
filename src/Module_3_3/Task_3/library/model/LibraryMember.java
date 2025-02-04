package Module_3_3.Task_3.library.model;

import Module_3_3.Task_3.library.system.Library;

import java.util.ArrayList;

public class LibraryMember {
    private String name;
    private int id;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Book> reservedBooks;
    private static int totalMembers = 0;

    public LibraryMember(String name) {
        this.name = name;
        this.id = totalMembers;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
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

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public ArrayList<Book> getReservedBooks() { return reservedBooks; }

    public boolean hasBook(Book book) {
        boolean found = false;
        for (Book b : borrowedBooks) {
            if (b.getIsbn().equals(book.getIsbn())) {
                found = true;
            }
        }
        return found;
    }
    public boolean hasReserved(Book book) {
        boolean found = false;
        for (Book b : reservedBooks) {
            if (b.getIsbn().equals(book.getIsbn())) {
                found = true;
            }
        }
        return found;
    }


    public void borrowBook(Book book) {
        if (!hasBook(book)) {
            borrowedBooks.add(book);
        }
    }

    public boolean returnBook(Book book) {
        if (hasBook(book)) {
            borrowedBooks.remove(book);
            return true;
        }
        return false;
    }

    public void reserveBook(Book book) {
        if (!hasReserved(book)) {
            reservedBooks.add(book);
        }
    }

    public boolean cancelReservation(Book book) {
        if (hasReserved(book)) {
            reservedBooks.remove(book);
            return true;
        }
        return false;
    }

    public void displayBooks() {
        if (!borrowedBooks.isEmpty()) {
            System.out.println(name + "'s borrowed books:");
            for (Book book : borrowedBooks) {
                System.out.println(book.getInfo());
            }
        }

        if (!reservedBooks.isEmpty()) {
            System.out.println(name + "'s reserved books:");
            for (Book book : reservedBooks) {
                System.out.println(book.getInfo());
            }
        }
    }
}
