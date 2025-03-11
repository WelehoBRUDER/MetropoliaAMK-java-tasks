package src;

public class Pen {
    private Color color;
    private boolean cap = true;
    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override public String toString() { return color; }
    }

    public Pen() {
        this.color = Color.RED;
    }

    public Pen(Color color) {
        this.color = color;
    }

    public void capOn() {
        this.cap = true;
    }

    public void capOff() {
        this.cap = false;
    }
    public String draw() {
        if (this.cap) return "";
        return "Drawing " + this.color;
    }

    public void changeColor(Color color) {
        if (!this.cap) return;
        this.color = color;
    }
}