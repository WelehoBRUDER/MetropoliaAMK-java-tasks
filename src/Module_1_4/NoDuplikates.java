package Module_1_4;

import java.util.Scanner;

public class NoDuplikates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = 0;
        // Robust error checking to prevent program from terminating due to bad input
        while (size <= 0) {
            System.out.print("Enter the size of the array: ");
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size <= 0) {
                    System.out.println("Array size must be greater than 0.");
                }
            } catch (Exception e) {
                System.out.println("Given input is not a number/integer");
            }
        }
        int[] array = new int[size];
        int n = 0;
        while (n < size) {
            System.out.print("Enter integer " + (n + 1) + ": ");
            try {
                int number = Integer.parseInt(scanner.nextLine());
                array[n] = number;
                n++;
            } catch (Exception e) {
                System.out.println("Given input is not a number/integer");
            }
        }
        // It's probably not optimal, but we check both arrays in a nested for loop
        // This gives us a not amazing operation time of O(n^2)
        // Only slightly mitigated by the break in the second loop
        // TODO: return to this problem when I find a better solution
        int[] withoutDuplicates = new int[size];
        for (int i = 0; i < size; i++) {
            // Create a variable to check if a duplicate is found
            boolean duplicated = false;
            for (int j = 0; j < withoutDuplicates.length; j++) {
                if (array[i] == withoutDuplicates[j]) {
                    // Mark as duplicate and break loop
                    duplicated = true;
                    break;
                }
            }
            if (!duplicated) {
                withoutDuplicates[i] = array[i];
            } else {
                // Workaround to mark duplicated values, not sure if I like this
                withoutDuplicates[i] = Integer.MIN_VALUE;
            }
        }
        System.out.println("Here is the array without duplicates:");
        for (int i = 0; i < size; i++) {
            // Check to prevent printing empty 0s
            if (withoutDuplicates[i] != Integer.MIN_VALUE) {
                System.out.print(withoutDuplicates[i] + " ");
            }
        }
    }
}
