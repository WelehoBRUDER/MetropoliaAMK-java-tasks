package Module_5_2.Task_1;

public class TicketReservation {
    private int tickets;

    public TicketReservation(int tickets) {
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
    }

    public synchronized boolean reserveTickets(int tickets) {
        if (this.tickets >= tickets) {
            this.tickets -= tickets;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicketReservation tr = new TicketReservation(25);
        System.out.println("Tickets at the start: " + tr.getTickets());
        final int numberOfCustomers = 15;
        for (int i = 0; i < numberOfCustomers; i++) {
            new Customer(tr).start();
        }
        System.out.println("Tickets at the end: " + tr.getTickets());
    }
}
