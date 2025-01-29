package Module_3_1.Task_4;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void calculateShape() {
        System.out.println("Area of " + color + " circle with radius " + radius + " is " + calculateArea());
    }
}
