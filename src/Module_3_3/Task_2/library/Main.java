package Module_3_3.Task_2.library;

import Module_3_3.Task_2.library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("1984", "George Orwell", "978-1443434973", 5);
        lib.addBook("Coding with JavaScript For Dummies", "Chris Minnick, Eva Holland", "978-1119056072", 2);
        lib.addMember("Tarmo");
        lib.addMember("Tim");

        lib.displayBooks();

        lib.borrowBook("978-1443434973", 0);
        lib.borrowBook("978-1119056072", 1);
        lib.returnBook("978-1443434973", 0);

        lib.displayBooks();
    }
}
