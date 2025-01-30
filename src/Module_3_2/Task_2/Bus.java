package Module_3_2.Task_2;

public class Bus extends AbstractVehicle {
    private String type;
    private String fuel;
    private String color;
    private int capacity;

    public Bus(String type, String color, String fuel, int capacity) {
        super(type, color, fuel);
        this.type = "Bus " + type;
        this.capacity = capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + "\nCapacity: " + capacity;
    }
}
