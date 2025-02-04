package Module_3_4.Task_2;

import java.io.*;
import java.util.ArrayList;

public class FibonacciSequence {
    private final long startingFibonacciA;
    private final long startingFibonacciB;
    private int len;
    private ArrayList<Long> fibonacciSequence;

    public FibonacciSequence(long a, long b, int len) {
        this.len = len;
        this.startingFibonacciA = a;
        this.startingFibonacciB = b;
        this.fibonacciSequence = new ArrayList<>();
    }

    public void generateFibonacciSequence() {
        fibonacciSequence.clear();

        // Initialize the fibonacci array
        this.fibonacciSequence.add(startingFibonacciA);
        this.fibonacciSequence.add(startingFibonacciB);

        for (int i = 2; i < len; i++) {
            fibonacciSequence.add(fibonacciSequence.get(i - 1) + fibonacciSequence.get(i - 2));
        }
    }

    public void writeFibonacciSequenceToFile() {

        try {
            String FILE_PATH = "src//Module_3_4//Task_2//fibonacci.csv";
            File file = new File(FILE_PATH);
            String output = fibonacciSequence.toString().replace("[", "").replace("]", "");
            System.out.println(file.getAbsolutePath());
            try {
                if (file.createNewFile()) {
                    FileWriter fw = new FileWriter(file);
                    fw.write(output);
                    fw.close();
                    System.out.println("File 'fibonacci.csv' created to " + file.getAbsolutePath());
                }
                else {
                    System.out.println("File already exists, writing to file");
                    BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH));
                    bw.write(output);
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error creating file" + e.getMessage());
            }


        } catch (Exception e) {
            System.out.println("Failed to create file." + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FibonacciSequence fibonacci = new FibonacciSequence(1L, 1L, 60);
        fibonacci.generateFibonacciSequence();
        fibonacci.writeFibonacciSequenceToFile();
    }
}
