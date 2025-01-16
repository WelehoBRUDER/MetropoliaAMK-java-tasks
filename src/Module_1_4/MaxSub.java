package Module_1_4;


import java.util.Scanner;

public class MaxSub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        try {
            int size = Integer.parseInt(scanner.nextLine());

            int[] array = new int[size];
            System.out.println("Enter the integers into the array:");
            int n = 0;
            while (n < size) {
                System.out.print("Enter integer " + (n + 1) + ": ");
                try {
                    array[n] = Integer.parseInt(scanner.nextLine());
                    n++;
                }
                catch (Exception e) {
                    System.out.println("Given input is not a number/integer.");
                }
            }

            // Initialize max sum variables
            int max = array[0];
            String maxSubarray = "";
            // Iterate through the loop
            for (int i = 0; i < array.length; i++) {
                // Iterate through current slice, starting from i
                for (int j = i; j < array.length; j++) {
                    // Initialize current sum variables
                    int sum = 0;
                    String subarray = "";
                    // Read through the current contiguous slice (from i to j)
                    // k <= j because j is already < array.length, so using just < would result in length - 2
                    for (int k = i; k <= j; k++) {
                        // Add current value to sum
                        sum += array[k];
                        subarray += k + 1; // Increment by 1 to display integers starting from 1 instead of 0
                    }
                    // If the current sum is more than prev max, it becomes the new max
                    if (sum > max) {
                        max = sum;
                        maxSubarray = subarray.charAt(0) + "-" + subarray.charAt(subarray.length() - 1);
                    }
                }
            }

            System.out.println();
            System.out.println("Maximum sum: " + max);
            System.out.println("Integers " + maxSubarray);
        }
        catch (Exception e) {
            System.out.println("Given input is not a number/integer.");
        }
    }
}
