package Module_3_2.Task_1;

public class Car implements Vehicle {
    final private String type = "Car";
    private String fuel;
    private String color;

    public Car(String color, String fuel) {
        this.color = color;
        this.fuel = fuel;
    }

    public void start() {
        System.out.println(type + " is starting...");
    }
    public void stop() {
        System.out.println(type + " is stopping...");
    }
    public String getInfo() {
        return "Type: " + type + "\nFuel: " + fuel + "\nColor: " + color;
    }
}
