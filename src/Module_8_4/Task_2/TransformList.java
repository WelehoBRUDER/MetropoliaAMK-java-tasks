import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformList {
    public static List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 5, 10, 7, 3, 1, 9, 12, 16));

    public static void main(String[] args) {
        List<Integer> example = numbers;
        System.out.println("Original List:");
        printList(numbers);

        numbers = numbers.stream().filter(n -> n % 2 == 1).toList();

        System.out.println("\n\nRemoved even numbers:");
        printList(numbers);

        numbers = numbers.stream().map(n -> n * 2).toList();
        System.out.println("\n\nDoubled remaining numbers:");
        printList(numbers);

        System.out.println("\n\nSum of remaining numbers: " + numbers.stream().reduce(0, (a, b) -> a + b));

        // Everything done in one line
        System.out.println("\nSum in one line: " + example.stream().filter(n -> n % 2 == 1).map(n -> n * 2).reduce(0, (a, b) -> a + b));
    }

    public static void printList(List<Integer> list) {
        list.stream().map(i -> i + " ").forEach(System.out::print);
    }
}
