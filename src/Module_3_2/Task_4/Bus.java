package Module_3_2.Task_4;

public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(String type, String color, Fuel fuel, int capacity) {
        super(type, color, fuel);
        this.type = "Bus " + type;
        this.capacity = capacity;
        this.fuelUsage = 22;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public double calculateFuelEfficiency() {
        // Just some mixing and matching to make this as close real consumption as possible
        return super.calculateFuelEfficiency() * 1.02;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nCapacity: " + capacity;
    }
}
