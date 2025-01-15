package Project_1_1;

public class Customer {
    private int id = 0;
    private long startTime;
    private long endTime;
    private static int idCounter = 1; // counter that increments every time a new instance is generated

    public int getId() {
        return id;
    }

    // Getters that are not utilized here
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    // Set id for current instance
    private void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long timeSpent() {
        return endTime - startTime;
    }

    // Initializes the customer with an automatic id
    public Customer() {
        setId(idCounter);
        idCounter++;
    }

    public String serviceText() {
        // Converting nanoTime to seconds
        double timeSpentDouble = (double) timeSpent() / Math.pow(10, 9);
        String timeSpentString = String.format("%.2f", timeSpentDouble);
        return "Customer (" + getId() + ") spent " + timeSpentString + "s in the service.";
    }
}
