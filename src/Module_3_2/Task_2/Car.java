package Module_3_2.Task_2;

public class Car extends AbstractVehicle {

    public Car(String type, String color, String fuel) {
        super(type, color, fuel);
        this.type = "Car " + type;
    }

}
