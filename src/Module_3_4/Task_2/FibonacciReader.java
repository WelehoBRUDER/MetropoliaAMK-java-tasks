package Module_3_4.Task_2;

import java.io.BufferedReader;
import java.io.FileReader;

public class FibonacciReader {
    private final String FILE_PATH;
    private BufferedReader br;

    public FibonacciReader(String filePath) {
        FILE_PATH = filePath;
        try {
            this.br = new BufferedReader(new FileReader(FILE_PATH));
        } catch (Exception e) {
            System.out.println("File does not exist.");
        }
    }

    public void readFibonacci() {
        if (br != null) {
            try {
                do {
                    System.out.println(br.readLine());
                }
                while (br.readLine() != null);

            } catch (Exception e) {
                System.out.println("Failed to read file.");
            }
        }
    }

    public static void main(String[] args) {
        FibonacciReader reader = new FibonacciReader("src//Module_3_4//Task_2//fibonacci.csv");
        reader.readFibonacci();
    }
}
