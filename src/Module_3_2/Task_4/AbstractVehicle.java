package Module_3_2.Task_4;

interface Vehicle {
    void start();
    void stop();
    String getInfo();
    double calculateFuelEfficiency();
}

interface ElectricVehicle {
    void charge();
}


public class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String color;
    protected Fuel fuel;
    protected int energy;
    protected int energyCapacity;
    protected double fuelUsage;

    public AbstractVehicle(String type, String color, Fuel fuel) {
        this.type = type;
        this.color = color;
        this.fuel = fuel;
        // Set these values to default within the abstract constructor
        this.energy = 0;
        this.energyCapacity = 1;
        this.fuelUsage = 5;
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

    public Fuel getFuel() {
        return fuel;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFuel(Fuel fuel) {
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
        return "Type: " + type + "\nColor: " + color + "\nFuel: " + fuel.label;
    }

    public double calculateFuelEfficiency() {
        return fuelUsage / fuel.efficiency;
    }

    public String getFuelEfficiency() {
        return type + " fuel efficiency: " + String.format("%.2f", calculateFuelEfficiency()) + fuel.mileageType;
    }

    public static void main(String[] args) {
        Car car = new Car("Porsche", "Red", Fuel.GASOLINE);
        Bus bus = new Bus("Omni", "Blue", Fuel.DIESEL, 30);
        ElectricMotorcycle eMotor = new ElectricMotorcycle("Yarn", "Grey", Fuel.ELECTRICITY, 60);
        System.out.println(car.getFuelEfficiency());
        System.out.println(bus.getFuelEfficiency());
        System.out.println(eMotor.getFuelEfficiency());
    }
}
