package Module_1_3;
import java.util.Scanner;

public class QuadraticFormula {
    static double x;
    static double y;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Coefficient a:");
        double a = scanner.nextDouble();
        System.out.println("Coefficient b:");
        double b = scanner.nextDouble();
        System.out.println("Coefficient c:");
        double c = scanner.nextDouble();

        // If coefficients are zero, the equation can not be calculated.
        if (a == 0.0 || b == 0.0 || c == 0.0) {
            System.out.println("Error: Coefficients can not be zero.");
            return;
        }

        // Calculate the determinant of the expression (b^2 - 4ac)
        double d = b * b - 4 * a * c;

        // Find the root
        if (d == 0.0) {
            x = -b / (2 * a);
        }

        else {
            x = (-b + Math.sqrt(d)) / (2 * a);
            y = (-b - Math.sqrt(d)) / (2 * a);
        }



        // Calculate the expression ax^2 + bx + c

        double solvedA = a * Math.pow(x, 2);
        double solvedB = b * x;

        // This variable is used to round the result to 3 decimal places
        int toDecimals = (int) Math.pow(10, 3);

        // Round this number to the 3 nearest decimal places
        double solved = (double) Math.round((solvedA + solvedB + c) * toDecimals) / toDecimals;

        // The result of the previous expression must be 0 for the equation to be valid.
        if (solved == 0.0 && d >= 0.0) {
            // Determinant is zero so there is only 1 root
            if (d == 0.0) {
                System.out.println("Only one real root!");
                System.out.println("x: " + x);
            }
            // Determinant is >0, show both roots
            else {
                System.out.println("Roots:");
                System.out.println(x + ", " + y);
            }
        }
        // Either determinant is less than zero, or the equation result is not zero
        else {
            System.out.println("No real roots");
        }

    }
}