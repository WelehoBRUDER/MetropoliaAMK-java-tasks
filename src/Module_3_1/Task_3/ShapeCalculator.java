package Module_3_1.Task_3;

public class ShapeCalculator {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(6);
        shapes[1] = new Rectangle(12, 18);
        shapes[2] = new Triangle(3, 5, 4);

        for (Shape shape : shapes) {
            shape.calculateShape();
        }
    }
}
