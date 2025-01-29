package Module_3_1.Task_3;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateArea() {
        // Calculate perimeter
        double s = (a + b + c) / 2;
        // Use Heron's formula to calculate the area
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public void calculateShape() {
        System.out.println("Area of triangle with sides (" + a + ", " + b + ", " + c + ") is " + calculateArea());
    }
}
