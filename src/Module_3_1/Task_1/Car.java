package Module_3_1.Task_1;

public class Car {

    protected double speed;
    protected double gasolineLevel;
    protected String typeName;
    protected double tankCapacity;
    protected double topSpeed;
    protected boolean cruiseControl;
    protected double targetSpeed;

    public void fillTank() {
        this.gasolineLevel = this.tankCapacity;
    }

    public void accelerate() {
        if (gasolineLevel > 0) {
            this.speed += 10;
            this.gasolineLevel -= 3;
            if (speed > topSpeed) {
                speed = topSpeed;
            }
            System.out.println("Accelerated to " + speed + " km/h");
        } else {
            System.out.println("Ran out of gas!");
            speed = 0;
        }
    }

    public void decelerate(double amount) {
        if (gasolineLevel > 0) {
            if (amount > 0) {
                speed = Math.max(0, speed - amount);
                gasolineLevel -= 3;
            }
            System.out.println("Decelerated to " + speed + " km/h");
        } else {
            System.out.println("Ran out of gas!");
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

    public void setTargetSpeed(double targetSpeed) {
        this.targetSpeed = targetSpeed;
        if (targetSpeed > topSpeed) {
            System.out.println("Target speed more than top speed, capped to " + topSpeed + " km/h");
            this.targetSpeed = topSpeed;
        }
        else if(targetSpeed < 0) {
            System.out.println("Target speed less than 0 km/h");
            this.targetSpeed = 0;
        }

    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

    public void turnCruiseControlOnOff() {
        cruiseControl = !cruiseControl;
        System.out.println("Cruise control is now " + (cruiseControl ? "on" : "off"));
        if (cruiseControl) {
            while (speed > targetSpeed || speed < targetSpeed) {
                if (gasolineLevel <= 0) {
                    System.out.println("Ran out of gas!");
                    turnCruiseControlOnOff();
                    break;
                }
                if (speed > targetSpeed) {
                    decelerate(speed - targetSpeed);
                } else if (speed < targetSpeed) {
                    accelerate();
                }
            }
        }
    }

    public Car(String typeName) {
        this(typeName, 100, 60);
    }

    public Car(String typeName, double tankCapacity, double topSpeed) {
        speed = 0;
        targetSpeed = 0;
        cruiseControl = false;
        gasolineLevel = 0;
        this.typeName = typeName;
        this.tankCapacity = tankCapacity;
        this.topSpeed = topSpeed;
    }
}

