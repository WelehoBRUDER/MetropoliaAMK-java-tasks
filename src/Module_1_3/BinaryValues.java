package Module_1_3;
import java.util.Scanner;

public class BinaryValues {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = 0;

        System.out.println("Enter a binary number: ");
        String binary = scanner.nextLine();

        // Loop through the binary string
        for (int i = 0; i < binary.length(); i++) {
            // Check if this value should be added
            if (binary.charAt(i) == '1') {
                // Add the current power of two to the total number
                decimal += (int) Math.pow(2, binary.length() - i - 1);
            }
        }

        System.out.println(binary + " in decimal is " + decimal);
    }
}
