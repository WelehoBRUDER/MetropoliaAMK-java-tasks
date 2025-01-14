package Module_1_3;
import java.util.Scanner;

public class MultiTable {
    final static int numOfQuestions = 10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the multiplication table refresher!");
        System.out.println("You will be asked 10 questions from the multiplication table.");
        System.out.println("Each correct answer will give you 1 point.");
        System.out.println("You need 10 points to pass this exam.");

        int score = 0;
        while (score < numOfQuestions) {
            System.out.println("Begin answering!");
            for (int i = 0; i < numOfQuestions; i++) {
                int factorA = (int) Math.ceil(Math.random() * 10);
                int factorB = (int) Math.ceil(Math.random() * 10);
                int result = factorA * factorB;

                System.out.println("What is " + factorA + " * " + factorB + "?");
                int userResult = scanner.nextInt();

                if (userResult == result) {
                    System.out.println("Your answer is correct!");
                    score++;
                }

                else {
                    System.out.println("Drat! Your answer is incorrect!");
                }

            }

            if (score == numOfQuestions) {
                System.out.println("Congratulations! You have gathered 10 points and are now a master of the multiplication table!");
            }
        }
    }
}
