package Module_3_1.Task_4;

public class ShapeCalculator {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(6, "red");
        shapes[1] = new Rectangle(12, 18, "green");
        shapes[2] = new Triangle(3, 5, 4, "blue");

        for (Shape shape : shapes) {
            shape.calculateShape();
        }
    }
}
