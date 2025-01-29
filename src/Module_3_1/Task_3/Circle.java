package Module_3_1.Task_3;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public void calculateShape() {
        System.out.println("Area of circle with radius " + radius + " is " + calculateArea());
    }
}
