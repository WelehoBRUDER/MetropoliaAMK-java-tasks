package Module_1_3;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Start integer");
        int start = in.nextInt();
        System.out.println("End integer");
        int end = in.nextInt();

        if (start > end) {
            System.out.println("End must be greater than start");
            return;
        }

        // Loop through all the integers between start and end
        prime: for (int i = start; i <= end; i++) {
            // Filter out numbers that are divisible by 2 and greater than 2
            if (i % 2 == 0 && i > 2) {
                continue;
            }
            int halfOfCheck = (int) (i / 2 + 1);
            // Check if current number is prime by finding divisions by 2s
            // The loop breaks upon the first even division found
            for (int j = 2; j < halfOfCheck; j++) {
                if (i % j == 0) {
                    continue prime;
                }
            }
            // If the current number held up to scrutiny, it is displayed as a prime
            System.out.println(i);
        }
    }
}
