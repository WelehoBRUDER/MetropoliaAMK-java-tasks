import java.util.Scanner;

public class AskInts {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println("The sum of the numbers is " + (first + second + third));
        System.out.println("The product of the numbers is " + (first * second * third));

        // The average was different from expected output due to it being an integer
        // It was then cast to a float, which correctly displayed decimals, but was still not entirely correct
        // The final modification was to cast the number to a double, allowing it to display longer decimals.
        double average = (double) (first + second + third) / 3;
        System.out.println("The average of the numbers is " + average);
    }
}