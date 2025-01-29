package Module_3_2.Task_1;

public class Bus implements Vehicle {
    final private String type = "Bus";
    private String fuel;
    private String color;
    private int capacity;

    public Bus(String color, String fuel, int capacity) {
        this.color = color;
        this.fuel = fuel;
        this.capacity = capacity;
    }

    public void start() {
        System.out.println(type + " is starting...");
    }
    public void stop() {
        System.out.println(type + " is stopping...");
    }
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color + "\nCapacity: " + capacity + " passengers";
    }
}
