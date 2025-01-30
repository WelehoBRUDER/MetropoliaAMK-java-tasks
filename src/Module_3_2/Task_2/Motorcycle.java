package Module_3_2.Task_2;

public class Motorcycle extends AbstractVehicle {

    public Motorcycle(String type, String color, String fuel) {
        super(type, color, fuel);
        this.type = "Motorcycle " + type;
    }

}
