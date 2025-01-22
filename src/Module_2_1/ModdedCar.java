package Module_2_1;

public class ModdedCar {
    public static class Car {
        private String type;
        private double speed;
        private int fuel = 0;
        private int tank = 15;

        public void fillTank() {
            this.fuel = this.tank;
        }

        public void accelerate() {
            this.speed += 10;
        }
    }
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla");
        myCar.fillTank();

        for (int i = 0; i < 6; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(15);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}
