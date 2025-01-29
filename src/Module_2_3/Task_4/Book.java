
package Module_2_3.Task_4;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int index;
    private ArrayList<String> reviews;
    private double rating;

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
        return '"' + title + '"' + " (" + publicationYear + ")" + " by " + author + " (Rating: " + rating + "), " + reviews.size() + " reviews";
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

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.rating = 0;
        this.reviews = new ArrayList<>();
    }
}
