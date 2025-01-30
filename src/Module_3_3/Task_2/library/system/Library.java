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

    public void addMember(String name) {
        this.members.add(new LibraryMember(name));
    }

    public void addBook(String title, String author, String isbn, int available) {
        this.books.add(new Book(title, author, isbn, available));
    }

    public LibraryMember getMemberById(int id) {
        return members.get(id);
    }

    public Book getBookById(String id) {
        for (Book book : books) {
            if (book.getIsbn().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String isbn, int memberId) {
        Book book = getBookById(isbn);
        LibraryMember member = getMemberById(memberId);
        // If book and member are valid and the book is available, it gets borrowed (so long as the member doesn't already have it)
        if (book != null && member != null && book.getAvailable() > 0 && !member.hasBook(isbn)) {
            book.setAvailable(book.getAvailable() - 1);
            member.borrowBook(isbn);
            System.out.println(member.getName() + " borrowed book " + book.getTitle());
        }
    }

    public void returnBook(String isbn, int memberId) {
        Book book = getBookById(isbn);
        LibraryMember member = getMemberById(memberId);
        // If book and member are valid and the specified member has it, it gets returned
        if (book != null && member != null) {
            if (member.returnBook(isbn)) {
                book.setAvailable(book.getAvailable() + 1);
                System.out.println(member.getName() + " returned book " + book.getTitle());
            }
        }
    }
}
