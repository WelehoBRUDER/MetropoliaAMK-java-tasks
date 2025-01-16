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

    // Create empty array and initialize uniques counting
    int[] withoutDuplicates = new int[size];
    int uniques = 1;
    // First element is always unique so we can do this
    withoutDuplicates[0] = array[0];
    // Go through the original array and compare it to the new array
    // skipping element at position 0 since it must be unique
    for (int i = 1; i < size; i++) {
      boolean duplicate = false;
      // Check if the unique list contains current element (only checking up to its size)
      for (int j = 0; j < uniques; j++) {
        if (array[i] == withoutDuplicates[j]) duplicate = true;
      }
      // uniques is incremented within brackets to ensure this stays a one-liner
      if (!duplicate) withoutDuplicates[uniques++] = array[i];
    }

    System.out.println("Here is the array without duplicates:");
    for (int i = 0; i < uniques; i++) {
      System.out.print(withoutDuplicates[i] + " ");
    }
  }
}
