package Module_2_3.Task_1;

import java.util.ArrayList;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("House of Leaves", "Mark Z. Danielewski", 2000);
        library.addBook("A Game of Thrones", "George R. R. Martin", 1996);
        library.addBook("A Clash of Kings", "George R. R. Martin", 1999);
        library.addBook("The Witcher", "Andrzej Sapkowski", 1990);
        library.displayBooks();

        System.out.println("Books by George R. R. Martin:");
        ArrayList<Book>  specificBooks = library.getBooksByAuthor("George R. R. Martin");
        library.displayBooks(specificBooks);
    }
}
