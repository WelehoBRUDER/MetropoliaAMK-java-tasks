package Module_5_1.Task_2;

public class ParallelSummation {
    private long sum;
    private int[] arr = new int[100000];
    private int slices;


    // Constructor that initializes the array with random numbers based on input
    public ParallelSummation(int min, int max) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1) + min);
        }
        this.slices = Runtime.getRuntime().availableProcessors();
    }

    // Method that calculates the sum of the array in parallel
    public void summation() {
        SummationWorker[] workers = new SummationWorker[slices];
        for (int i = 0; i < slices; i++) {
            int start = i * (arr.length / slices);
            int end = (i + 1) * (arr.length / slices);
            // Ensure that the last thread will calculate eveything left, if that doesn't happen naturally.
            workers[i] = new SummationWorker(arr, start, i >= slices - 1 ? arr.length : end);
            workers[i].start();
        }
        // Wait for all threads to finish and sum their results
        for (int i = 0; i < slices; i++) {
            try {
                workers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += workers[i].sum;
        }
        System.out.println("Sum: " + sum);
    }

    // Worker class that calculates the sum of a slice of the array
    public static class SummationWorker extends Thread {
        private int[] arr;
        private long sum;
        private int start;
        private int end;

        public SummationWorker(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
        }
    }

    public static void main(String[] args) {
        ParallelSummation ps = new ParallelSummation(10, 35);
        ps.summation();
    }
}
