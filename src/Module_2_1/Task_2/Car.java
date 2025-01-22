package Module_2_1.Task_2;

public class Car {

    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double tankCapacity;
    private double topSpeed;

    void fillTank() {
        this.gasolineLevel = this.tankCapacity;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            this.speed += 10;
            if (speed > topSpeed) {
                speed = topSpeed;
            }
        } else {
            speed = 0;
        }
    }

    void decelerate(int amount) {
        if (gasolineLevel > 0) {

            if (amount > 0) {
                speed = Math.max(0, speed - amount);
            }
        } else {
            speed = 0;
        }
    }

    public double getSpeed() {
        return speed;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }

    String getTypeName() {
        return typeName;
    }

    public Car(String typeName) {
        this(typeName, 100, 60);
    }

    public Car(String typeName, double tankCapacity, double topSpeed) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
        this.tankCapacity = tankCapacity;
        this.topSpeed = topSpeed;
    }
}

