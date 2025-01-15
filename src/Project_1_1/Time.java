package Project_1_1;

public class Time {
    // Called meanTime to differentiate from the avg variable
    static double meanTime;
    public static void main(String[] args) {
        // Define how many times the application should be run
        int times = 7;
        for (int i = 0; i < times; i++) {
            // Create new instances of ServicePoint and CustomerGenerator
            Service.ServicePoint sp = new Service.ServicePoint();
            Service.CustomerGenerator cg = new Service.CustomerGenerator(sp,10);
            // Generate customers and start serve method
            cg.generate();
            sp.serve();
            // Calculate average time and add it to the meanTime total
            double avg = (double) (sp.totalServiceTime / sp.customersServed);
            meanTime += avg;
            // Log application run number (operation)
            System.out.println((i + 1) + ". OPERATION");
            // Log the mean time for this run of the application
            System.out.println("Average service time: " + avg / 1000 + "s");
        }
        // Calculate the mean service time across all operations and log it
        double meanAvg = (meanTime / times) / 1000;
        System.out.println("In " + times + " operations, average service time was: " + String.format("%.3f", meanAvg) + "s");
    }
}
