package Module_3_2.Task_4;

public class Car extends AbstractVehicle {

    public Car(String type, String color, Fuel fuel) {
        super(type, color, fuel);
        this.type = "Car " + type;
        this.fuelUsage = 5.5;
    }

    public double calculateFuelEfficiency() {
        // Just some mixing and matching to make this as close real consumption as possible
        return super.calculateFuelEfficiency() * 1.05;
    }

}
