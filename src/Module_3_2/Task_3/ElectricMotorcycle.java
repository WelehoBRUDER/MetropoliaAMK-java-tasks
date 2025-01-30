package Module_3_2.Task_3;


public class ElectricMotorcycle extends AbstractVehicle {
    private int energyCapacity;

    public ElectricMotorcycle(String type, String color, String fuel, int ec) {
        super(type, color, fuel);
        this.type = "Electric Motorcycle " + type;
        this.energyCapacity = ec;
    }

    @Override
    public void charge() {
        // To make Electric Motorcycle different from Electric Car, its tank capacity has a new property.
        // It can be overcharged to 133%, which will eventually make it go 33% faster while the overcharge remains.
        // This will also make the bike drain faster and is not very efficient.
        this.energy = Math.min(this.energy + 20, (int) (this.energyCapacity * 1.333));
        System.out.println(type + " charged to " + this.tankCharge() + "%");
        if (tankCharge() > 100) {
            System.out.println("Overcharged! " + this.type + " moves " + (this.tankCharge() - 100) + "% faster until it depletes!");
        }
    }

}
