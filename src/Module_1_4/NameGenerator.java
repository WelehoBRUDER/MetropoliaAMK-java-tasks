package Module_1_4;

import java.util.Scanner;


public class NameGenerator {
    private String[] firstNames = {"Jack", "Tom", "Henry", "Lisa", "Tina", "Mona", "Linzi", "Pekka", "Tarmo"};
    private String[] lastNames = {"Smith", "Doe", "Jones", "Timber", "Lakes", "Woods", "Suomalainen", "Addams", "Baldwin"};

    public String generateName() {
        String name = firstNames[(int) (Math.random() * firstNames.length)] + " " + lastNames[(int) (Math.random() * firstNames.length)];
        return name;
    }

    public static void main(String[] args) {
        NameGenerator nameGen = new NameGenerator();
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many names would you like to generate?: ");
        try {
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.println(nameGen.generateName());
            }
        }
        catch (Exception e) {
            System.out.println("Given input is not a number/integer");
        }
    }
}
