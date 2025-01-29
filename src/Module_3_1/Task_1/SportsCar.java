package Module_3_1.Task_1;

public class SportsCar extends Car {

    public SportsCar(String typeName) {
        super(typeName);
    }

    public SportsCar(String typeName, double tankCapacity, double topSpeed) {
        super(typeName, tankCapacity, topSpeed);
    }

    // It's better because it's twice as fast! (at accelerating)
    public void accelerate() {
        if (gasolineLevel > 0) {
            this.speed += 20;
            this.gasolineLevel -= 6;
            if (speed > topSpeed) {
                speed = topSpeed;
            }
            System.out.println("Accelerated to " + speed + " km/h");
        } else {
            System.out.println("Ran out of gas!");
            speed = 0;
        }
    }

    // It's better because it consumes no gas!
    public void decelerate(double amount) {
        if (gasolineLevel > 0) {
            if (amount > 0) {
                speed = Math.max(0, speed - amount);
            }
            System.out.println("Decelerated to " + speed + " km/h");
        } else {
            System.out.println("Ran out of gas!");
            speed = 0;
        }
    }

    public static void main(String[] args) {
        SportsCar car = new SportsCar("Car");
        car.fillTank();
        car.accelerate();
    }

}
