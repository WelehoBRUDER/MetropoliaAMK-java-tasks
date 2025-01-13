package Module_1_2;
import java.util.Scanner;

public class MedievalMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final float luotiWeight = (float) 13.28;
        final float naulaWeight =  luotiWeight * 32;
        final float leiviskaWeight =  naulaWeight * 20;

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
