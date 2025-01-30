package Module_3_3.Task_2.library.system;

import Module_3_3.Task_2.library.model.Book;
import Module_3_3.Task_2.library.model.LibraryMember;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addMember(String name, String id) {
        this.members.add(new LibraryMember(name, id));
    }

    public void addBook(String title, String author, String isbn, int available) {
        this.books.add(new Book(title, author, isbn, available));
    }

    public LibraryMember getMemberById(String id) {
        for (LibraryMember member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    public Book getBookById(String id) {
        for (Book book : books) {
            if (book.getIsbn().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String isbn, String memberId) {
        Book book = getBookById(isbn);
        LibraryMember member = getMemberById(memberId);
        if (book != null && member != null && book.getAvailable() > 0) {
            book.setAvailable(book.getAvailable() - 1);
            member.borrowBook(isbn);
        }
    }
}
