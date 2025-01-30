package Module_3_2.Task_2;

public class Motorcycle extends AbstractVehicle {
    private String type;
    private String fuel;
    private String color;

    public Motorcycle(String type, String color, String fuel) {
        super(type, color, fuel);
        this.type = "Motorcycle " + type;
    }

}
