package Module_1_2;
import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give a temperature in fahrenheit:");
        double fahrenheit = scanner.nextDouble();

        double ratio = (double) 5 / 9;

        double celsius = (fahrenheit - 32) * ratio;
        System.out.println("Celsius: " + String.format("%.1f", celsius) + "C");
    }
}