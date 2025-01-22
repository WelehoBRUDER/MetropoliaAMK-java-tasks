package Module_2_1.Task_4;

public class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla", 15, 130);
        //myCar.fillTank();

//        for (int i = 0; i < 6; i++) {
//            myCar.accelerate();
//            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
//        }
//
//        while (myCar.getSpeed() > 0) {
//            myCar.decelerate(15);
//            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
//        }

        myCar.fillTank();
        myCar.setTargetSpeed(129);
        System.out.println("Target speed: " + myCar.getTargetSpeed() + " km/h");
        myCar.turnCruiseControlOnOff();
    }
}
