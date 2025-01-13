package Module_1_2;
import java.util.Scanner;

public class MedievalMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double luotiWeight = 13.28;
        final double naulaWeight =  luotiWeight * 32;
        final double leiviskaWeight =  naulaWeight * 20;

        System.out.println("Weight (g): ");
        double grams = scanner.nextDouble();

        final double gramsInitial = grams;

        int leiviskat = (int) (grams / leiviskaWeight);
        grams -= leiviskat * leiviskaWeight;
        int naulat = (int) (grams / naulaWeight);
        grams -= naulat * naulaWeight;
        double luodit = grams / luotiWeight;
        System.out.println(gramsInitial + " grams is " + leiviskat + " leiviskä, " + naulat + " naula, " + "and " + String.format("%.2f", luodit) + " luoti.");
    }
}
