package Module_2_3.Task_1;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int index;

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

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
}
