package Project_1_1;

import java.util.LinkedList;
import java.util.Scanner;

public class Queue {
    public static LinkedList<Customer> customers = new LinkedList<>();

    // Creates new Customer instance and initializes queue starting time
    // then adds it to the customers list
    public static void addCustomer() {
        Customer customer = new Customer();
        customer.setStartTime(System.nanoTime());
        customers.addFirst(customer);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        addCustomer();

        // Loop until there is nothing left in the customers list
        while (!customers.isEmpty()) {
            System.out.println("Customers in queue: " + customers.size());
            System.out.println("Type 'add' to add new customer or 'remove' to remove customer: ");
            String action = scanner.nextLine();
            // Check if the user typed "remove", if yes, then remove latest customer and print queue time
            if (action.equals("remove")) {
                Customer customer = customers.removeLast();
                customer.setEndTime(System.nanoTime());
                System.out.println(customer.serviceText());
            }
            // If the user typed "add", add a new customer to the queue
            else if (action.equals("add")) {
                addCustomer();
            }
        }
    }
}
