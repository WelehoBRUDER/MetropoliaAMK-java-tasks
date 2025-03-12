import java.util.ArrayList;
import java.util.Arrays;

public class LambdaListManipulation {
    public static int number = 0;

    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(10, 5, 8, 20, 15, 3, 12));

        System.out.println("Original list:");
        printList(ints);

        // Filter out even numbers
        ints.removeIf(i -> i % 2 == 0);

        System.out.println("\n\nList after removing even numbers:");
        printList(ints);

        // Double all odd numbers
        ints.replaceAll(i -> i % 2 == 1 ? i * 2 : i);

        System.out.println("\n\nList after doubling all odd numbers:");
        printList(ints);

        ints.forEach(i -> number += i);
        System.out.println("\n\nSum of all numbers in the list: " + number);
    }

    public static void printList(ArrayList<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
