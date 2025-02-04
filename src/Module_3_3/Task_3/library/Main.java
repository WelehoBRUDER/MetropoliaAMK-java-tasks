package Module_3_3.Task_3.library;

import Module_3_3.Task_3.library.system.Library;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addBook("1984", "George Orwell", "978-1443434973", 5);
        lib.addBook("Coding with JavaScript For Dummies", "Chris Minnick, Eva Holland", "978-1119056072", 2);
        lib.addMember("Tarmo");
        lib.addMember("Tim");

        lib.displayBooks();
        System.out.println();

        lib.borrowBook("978-1443434973", 0);
        lib.borrowBook("978-1119056072", 1);
        lib.displayBooks();
        lib.returnBook("978-1443434973", 0);

        System.out.println();

        lib.getMemberById(1).displayBooks();
        System.out.println();

        lib.reserveBook("978-1443434973", 1);
        System.out.println();

        lib.getMemberById(1).displayBooks();
        System.out.println();

        lib.displayBooks();
        System.out.println();

        lib.cancelReservation("978-1443434973", 1);
        lib.displayBooks();

        System.out.println();
        lib.getMemberById(1).displayBooks();
    }
}
