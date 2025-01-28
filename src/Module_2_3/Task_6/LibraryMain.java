package Module_2_3.Task_6;

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

        // Add users
        library.addUser("Henrik", 27);
        library.addUser("Talm", 16);

        // Test users
        User henrik = library.getUserByName("Henrik");
        User talm = library.getUserByName("Talm");

        library.borrowBook("The Witcher", henrik.getName());
        System.out.println("Books after borrowing:");
        library.displayBooks();
        System.out.println("Henrik's books:");
        henrik.displayBookNames();
        library.returnBook(henrik.getBookByName("The Witcher"), henrik.getName());
        System.out.println("Books after returning:");
        library.displayBooks();
        System.out.println("Henrik's books after returning:");
        henrik.displayBookNames();

    }
}
