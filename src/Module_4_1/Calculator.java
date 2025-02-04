package Module_4_1;

public class Calculator {
    private int result = 0;

    public void add(int number) {
        // Throw exception if number is negative
        if (number < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
        result += number;
    }

    public void reset() {
        result = 0;
    }

    public int getResult() {
        return result;
    }

    // Create main method that tests the Calculator class
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(5);
        System.out.println(calculator.getResult());
        calculator.add(10);
        System.out.println(calculator.getResult());
        calculator.reset();
        System.out.println(calculator.getResult());
        calculator.add(-5);
    }
}
