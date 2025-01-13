package Module_1_2;
import java.util.Scanner;

public class TriangleLegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Length of leg 1:");
        double leg1 = scanner.nextDouble();
        System.out.println("Length of leg 2:");
        double leg2 = scanner.nextDouble();

        // Calculate hypotenuse with the formula sqrt(a^2 + b^2)
        double hypotenuse = Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2));
        System.out.println("Hypotenuse length: " + hypotenuse);
    }
}