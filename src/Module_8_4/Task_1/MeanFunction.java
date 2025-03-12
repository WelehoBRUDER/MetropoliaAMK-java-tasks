import java.util.ArrayList;
import java.util.Arrays;

public class MeanFunction {
    public static ArrayList<Double> numbers = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 5.5, 3.0, 12.0, 4.0, 5.0, 1.5, 9.8, 200.0));
    public static double mean = 0.0;
    public static int index = 0;
    public static void main(String[] args) {
        calcNext(index);
    }

    public static void calcNext(int i) {
        if (i == numbers.size()) {
            mean = mean / i;
            System.out.println("Mean: " + String.format("%.2f", mean));
            return;
        }
        mean = mean + numbers.get(i);
        i++;
        calcNext(i);
    }
}
