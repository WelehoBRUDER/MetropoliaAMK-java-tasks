import java.util.ArrayList;
import java.util.Arrays;

public class MeanFunction {
    public static ArrayList<Double> numbers = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 5.5, 3.0, 12.0, 4.0, 5.0, 1.5, 9.8, 200.0));
    public static double mean = 0.0;

    public static void main(String[] args) {
        mean = numbers.stream().reduce(mean, (a, b) -> a + b) / numbers.size();
        System.out.println("Mean: " + String.format("%.2f", mean));
    }
}
