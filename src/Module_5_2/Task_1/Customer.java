package Module_5_2.Task_1;

public class Customer extends Thread {
    private static int counter = 1;
    private int id;
    private TicketReservation tr;
    private int tickets;

    public Customer(TicketReservation tr) {
        this.id = counter++;
        this.tr = tr;
        this.tickets = (int) (Math.random() * 5) + 1;
    }
    public void run() {
        boolean success = tr.reserveTickets(tickets);
        if (success) {
            System.out.println("Customer " + id + " reserved " + tickets + " tickets.");
        } else {
            System.out.println("Customer " + id + " failed to reserve " + tickets + " tickets.");
        }
    }
}
