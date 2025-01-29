package Module_3_1.Task_3;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double calculateArea() {
        return width * height;
    }

    public void calculateShape() {
        System.out.println("Area of rectangle with width " + width + " and height "  + height + " is " + calculateArea());
    }
}
