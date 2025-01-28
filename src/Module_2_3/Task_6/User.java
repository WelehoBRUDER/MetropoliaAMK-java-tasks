package Module_2_3.Task_6;

import Module_2_3.Task_4.Book;

import java.util.ArrayList;


public class User {
    private String name;
    private int age;
    private ArrayList<Book> borrowedBooks;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Book getBookByName(String bookName) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equals(bookName)) {
                return book;
            }
        }
        return null;
    }

    public ArrayList<Book> getBookList() {
        return borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayBookNames() {
        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle());
        }
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }
}
