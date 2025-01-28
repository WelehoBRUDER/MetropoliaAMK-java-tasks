package Module_2_3.Task_6;

import java.util.ArrayList;
import Module_2_3.Task_4.Book;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(String title, String author, int year) {
        books.add(new Book(title, author, year));
    }

    public Book getBook(int index) {
        return this.books.get(index);
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

    public void addUser(String name, int age) {
        users.add(new User(name, age));
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void borrowBook(String title, String user) {
        User myUser = getUserByName(user);
        Book book = null;
        for (int i = 0; i < books.size(); i++) {
            Book book1 = books.get(i);
            if (book1.getTitle().equals(title)) {
                book = book1;
                books.remove(i);
                break;
            }
        }
        myUser.addBook(book);
    }

    public void returnBook(Book book, String user) {
        books.add(book);
        User myUser = getUserByName(user);
        myUser.removeBook(book);
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
    public boolean isBookAvailable(String title) {
        boolean isAvailable = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                isAvailable = true;
                break;
            }
        }
        return isAvailable;
    }

    public double getAverageBookRating() {
        double sum = 0;
        for (Book book : books) {
            sum += book.getRating();
        }
        return sum / books.size();
    }

    public Book getMostReviewedBook() {
        Book mostReviewedBook = null;
        for (Book book : books) {
            if (mostReviewedBook == null) {
                mostReviewedBook = book;
            }
            if (book.getReviews().size() > mostReviewedBook.getReviews().size()) {
                mostReviewedBook = book;
            }
        }
        return mostReviewedBook;
    }
}
