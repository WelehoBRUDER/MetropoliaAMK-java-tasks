package Project_1_1;

import java.util.LinkedList;
import java.util.Scanner;

public class Queue {
    public static LinkedList<Customer> customers = new LinkedList<>();

    public static void addCustomer() {
        Customer customer = new Customer();
        customer.setStartTime(System.nanoTime());
        customers.addFirst(customer);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        addCustomer();

        while (!customers.isEmpty()) {
            System.out.println("Customers in queue: " + customers.size());
            System.out.println("Type 'add' to add new customer or 'remove' to remove customer: ");
            String action = scanner.nextLine();
            if (action.equals("remove")) {
                Customer customer = customers.removeLast();
                customer.setEndTime(System.nanoTime());
                System.out.println(customer.serviceText());
            }
            else if (action.equals("add")) {
                addCustomer();
            }
        }
    }
}
