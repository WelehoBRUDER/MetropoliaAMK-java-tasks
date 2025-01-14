package Module_1_3;
import java.util.Scanner;

public class BinaryValues {
    static int decimal;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a binary number: ");
        String binary = scanner.nextLine();

        for (int i = binary.length() - 1; i >= 0; i--) {
            // Convert the binary char to an integer (0 or 1)
            int num = Integer.parseInt(String.valueOf(binary.charAt(i)));
            // Add the resulting power of two to the decimal value
            decimal += (int) (Math.pow(2, binary.length() - i - 1) * num);
        }

        System.out.println(binary + " in decimal is " + decimal);
    }
}
