package Module_2_3.Task_2;

public class Book {
    private String title;
    private String author;
    private int publicationYear;

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

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String displayInfo() {
       return '"' + title + '"' + " (" + publicationYear + ")" + " by " + author;
    }

    public String getOnlyBookInfo() {
        return '"' + title + '"' + " (" + publicationYear + ")";
    }

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}
