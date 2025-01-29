package Module_3_1.Task_2;

import Module_3_1.Task_1.Car;

public class Bus extends Car {
    protected int passengers;
    protected int seats;

    public Bus(String typeName) {
        super(typeName);
        this.passengers = 0;
        this.seats = 12;
    }

    public Bus(String typeName, int seats) {
        super(typeName);
        this.passengers = 0;
        this.seats = seats;
    }

    public Bus(String typeName, double tankCapacity, double topSpeed) {
        super(typeName, tankCapacity, topSpeed);
        this.passengers = 0;
        this.seats = 12;
    }

    public Bus(String typeName, double tankCapacity, double topSpeed, int seats) {
        super(typeName, tankCapacity, topSpeed);
        this.passengers = 0;
        this.seats = seats;
    }

    public int getPassengers() {
        return passengers;
    }

    public void passengerEnter() {
        if (this.passengers < this.seats) {
            passengers++;
            System.out.println("Passenger " + this.passengers + " entered");
        }
    }

    public void passengerExit() {
        if (this.passengers > 0) {
            System.out.println("Passenger " + this.passengers + " exited");
            passengers--;
        }
    }

    public static void main(String[] args) {
        Bus bus = new Bus("Bus");
        bus.fillTank();
        bus.passengerEnter();
        bus.passengerEnter();
        bus.passengerEnter();
        System.out.println(bus.getPassengers());
        bus.accelerate();
        bus.accelerate();
        bus.accelerate();
        bus.decelerate(20);
        bus.passengerExit();
        bus.passengerExit();
        System.out.println(bus.getPassengers());
    }
}
