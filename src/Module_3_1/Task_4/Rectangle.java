package Module_3_1.Task_4;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double calculateArea() {
        return width * height;
    }

    public void calculateShape() {
        System.out.println("Area of " + color + " rectangle with width " + width + " and height "  + height + " is " + calculateArea());
    }
}
