package Module_3_2.Task_2;

interface Vehicle {
    void start();
    void stop();
    String getInfo();
}


public class AbstractVehicle implements Vehicle {
    protected String type;
    protected String color;
    protected String fuel;

    public AbstractVehicle(String type, String color, String fuel) {
        this.type = type;
        this.color = color;
        this.fuel = fuel;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getFuel() {
        return fuel;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void start() {
        System.out.println(type + " starting...");
    }

    public void stop() {
        System.out.println(type + " stopping...");
    }

    public String getInfo() {
        return "Type: " + type + "\nColor: " + color + "\nFuel: " + fuel;
    }
}
