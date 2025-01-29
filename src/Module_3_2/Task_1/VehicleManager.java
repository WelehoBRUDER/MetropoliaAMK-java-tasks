package Module_3_2.Task_1;

public class VehicleManager {
    public static void main(String[] args) {
        Car car = new Car("Red", "Petrol");
        Motorcycle motorcycle = new Motorcycle("Black", "Gasoline");
        Bus bus = new Bus("Blue", "Diesel", 40);

        car.start();
        car.stop();
        System.out.println(car.getInfo());

        System.out.println();

        motorcycle.start();
        motorcycle.stop();
        System.out.println(motorcycle.getInfo());

        System.out.println();

        bus.start();
        bus.stop();
        System.out.println(bus.getInfo());
    }
}
