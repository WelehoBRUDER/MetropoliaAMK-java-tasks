package Module_3_3.Task_3.library.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int available;
    private boolean reserved = false;

    public Book(String title, String author, String isbn, int available) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = available;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public boolean isReserved() {
        return reserved;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getInfo() {
        if (reserved) return '"' + title + '"' + " by " + author + ", (" + available + " in stock, isbn: " + isbn + ")" + " RESERVED";
        return '"' + title + '"' + " by " + author + ", (" + available + " in stock, isbn: " + isbn + ")";
    }


}
