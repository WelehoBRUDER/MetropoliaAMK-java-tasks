package Project_1_1;

public class Service {

    public static class ServicePoint {
        Queue queue = new Queue();
        // TASK 6 - CALCULATE THE AVERAGE SERVICE TIME
        int customersServed = 0;
        long totalServiceTime = 0;
        // -------------------------------------------

        void addToQueue() {
            queue.addCustomer();
        }

        Customer removeFromQueue() {
            return queue.customers.removeLast();
        }

        void serve() {
            while (!queue.customers.isEmpty()) {
                // Removes next-in-line customer and returns it
                Customer c = removeFromQueue();
                // Generate a random time between 0 and 0.37s (0-370 in ms)
                long serviceTime = (long) (Math.random() * 370);
                // Sleep for the generated random time
                try {
                    Thread.sleep(serviceTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // TASK 6 - CALCULATE THE AVERAGE SERVICE TIME
                // Values for calculating the mean service time
                totalServiceTime += serviceTime;
                customersServed++;
                // -------------------------------------------

                // Set end time for the customer to calculate how long they spent in the queue + getting serviced
                c.setEndTime(System.nanoTime() + serviceTime);
                // Call the customer's serviceText method to print how long they spent here
                System.out.println(c.serviceText());
            }
        }
    }


    // Class that populates the customer queue with instances of Customer class
    public static class CustomerGenerator {
        int cgNum;
        ServicePoint serve;
        public CustomerGenerator(ServicePoint sp, int num) {
            cgNum = num;
            serve = sp;
        }

        public void generate() {
            for (int i = 0; i < cgNum; i++) {
                serve.addToQueue();
            }
        }
    }



    public static void main(String[] args) {
        // Create new instance of ServicePoint and CustomerGenerator (defined with 10 customers)
        ServicePoint sp = new ServicePoint();
        CustomerGenerator cg = new CustomerGenerator(sp,10);
        // Generate the specified number of customers and begin serving
        cg.generate();
        sp.serve();
    }
}
