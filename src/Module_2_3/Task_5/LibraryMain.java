package Module_2_3.Task_5;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("House of Leaves", "Mark Z. Danielewski", 2000);
        library.addBook("A Game of Thrones", "George R. R. Martin", 1996);
        library.addBook("A Clash of Kings", "George R. R. Martin", 1999);
        library.addBook("The Witcher", "Andrzej Sapkowski", 1990);

        // Add ratings to each book
        library.getBook(0).setRating(3.7);
        library.getBook(1).setRating(4.2);
        library.getBook(2).setRating(4.3);
        library.getBook(3).setRating(3.9);

        // Add reviews
        library.getBook(0).addReview("Phenomenal");
        library.getBook(1).addReview("Incredible start");
        library.getBook(2).addReview("Wow!");
        library.getBook(2).addReview("Quite the book!");
        library.getBook(3).addReview("Toss a coin");

        // Test these features
        library.displayBooks();
        System.out.println("Average rating: " + String.format("%.2f", library.getAverageBookRating()));
        System.out.println("Most reviewed book: " + library.getMostReviewedBook().displayInfo());

        System.out.println("Book 'House of Leaves' available: " + (library.isBookAvailable("House of Leaves") ? "Yes" : "No"));
        System.out.println("Book 'Vaahteramäen Eemeli' available: " + (library.isBookAvailable("Vaahteramäen Eemeli") ? "Yes" : "No"));
    }
}
