package Module_3_2.Task_3;

interface Vehicle {
    void start();
    void stop();
    String getInfo();
}

interface ElectricVehicle {
    void charge();
}


public class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String color;
    protected String fuel;
    protected int energy;
    protected int energyCapacity;

    public AbstractVehicle(String type, String color, String fuel) {
        this.type = type;
        this.color = color;
        this.fuel = fuel;
        // Set these values to default within the abstract constructor
        this.energy = 0;
        this.energyCapacity = 1;
    }

    // Returns the % of charge remaining in the tank
    public double tankCharge() {
        return ((double) energy / energyCapacity) * 100;
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

    public void charge() {
        System.out.println(type + " charging...");
    }

    public String getInfo() {
        return "Type: " + type + "\nColor: " + color + "\nFuel: " + fuel;
    }
}
