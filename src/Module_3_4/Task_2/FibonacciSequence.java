package Module_3_4.Task_2;

import java.io.*;
import java.util.ArrayList;

public class FibonacciSequence {
    public long startingFibonacciA;
    public long startingFibonacciB;
    public int len;
    public ArrayList<Long> fibonacciSequence;
    public String filename;

    public FibonacciSequence(long a, long b, int len, String filename) {
        this.len = len;
        this.startingFibonacciA = a;
        this.startingFibonacciB = b;
        this.fibonacciSequence = new ArrayList<>();
        this.filename = filename;
    }

    public ArrayList<Long> generateFibonacciSequence() {
        fibonacciSequence.clear();

        // Initialize the fibonacci array
        this.fibonacciSequence.add(startingFibonacciA);
        this.fibonacciSequence.add(startingFibonacciB);

        for (int i = 2; i < len; i++) {
            fibonacciSequence.add(fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2));
        }

        return fibonacciSequence;
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacci = new FibonacciSequence(1L, 1L, 60, "fibonacci.csv");
        ArrayList<Long> sequence = fibonacci.generateFibonacciSequence();

        try {
            File file = new File("src//Module_3_4//Task_2//" + fibonacci.filename);
            System.out.println(file.getAbsolutePath());
            try {
                if (file.createNewFile()) {
                    FileWriter fw = new FileWriter(file);
                    for (long number : sequence) {
                        fw.write(number + ",");
                    }
                    fw.close();
                }
                else {
                    System.out.println("File already exists");
                }
            } catch (IOException e) {
                System.out.println("Error creating file" + e.getMessage());
            }


        } catch (Exception e) {
            System.out.println("Failed to create file." + e.getMessage());
        }
    }
}
