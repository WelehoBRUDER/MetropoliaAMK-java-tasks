# Calculator

### Code
```
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
```

Explain the purpose of the Calculator class and its methods.

### Output
```
5
15
0
Exception in thread "main" java.lang.IllegalArgumentException: Number must be positive
	at Module_4_1.Calculator.add(Calculator.java:10)
	at Module_4_1.Calculator.main(Calculator.java:24)
```

### Explanation
The Calculator class is a simple class that adds numbers together. It has three methods:  
- add(int number): Adds the input number to the result. If the input number is negative, it throws an IllegalArgumentException.  
- reset(): Resets the result to 0.  
- getResult(): Returns the current result.  

In the main method, we create a new Calculator object and call the add method with 5 and 10.  
We then print the result after each addition.  
After that, we reset the calculator and print the result again.  
Finally, we call the add method with a negative number, which throws an IllegalArgumentException.
