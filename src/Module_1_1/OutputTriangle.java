package Module_1_1;

public class OutputTriangle {
    public static void main(String[] args) {
        final int rows = 4;
        final int maxItems = rows * 2 + 1;
        for (int i = 0; i < rows; i++) {
            int spaces = maxItems / 2 - i;
            int stars = i * 2 + 1;
            System.out.println(" ".repeat(spaces) + "*".repeat(stars));
        }
    }
}
