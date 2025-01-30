package Module_3_2.Task_3;

public class ElectricCar extends AbstractVehicle {
    private int energyCapacity;

    public ElectricCar(String type, String color, String fuel, int ec) {
        super(type, color, fuel);
        this.type = "Electric Car " + type;
        this.energyCapacity = ec;
    }

    // This doesn't need to be a hard coded value, but not doing it this way would bloat the class just a little.
    @Override
    public void charge() {
        // Take minimum between energy and tank capacity
        this.energy = Math.min(this.energy + 25, this.energyCapacity);
        System.out.println(type + " charged to " + this.tankCharge() + "%");
    }

    public static void main(String[] args) {
        ElectricCar eCar = new ElectricCar("Fiat", "#FF0000", "Electric", 100);
        ElectricMotorcycle eMotor = new ElectricMotorcycle("Fiat", "#FF0000", "Electric", 50);
        // Demonstration of how the charge method works.
        eCar.charge();
        eCar.charge();
        eCar.charge();
        eMotor.charge();
        eMotor.charge();
        eMotor.charge();
        eMotor.charge();
    }

}
