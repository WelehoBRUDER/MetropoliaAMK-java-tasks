package Project_1_1;

public class Customer {
    private int id = 0;
    private long startTime;
    private long endTime;
    private static int idCounter = 1;

    public int getId() {
        return id;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

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

    public Customer() {
        setId(idCounter);
        idCounter++;
    }

    public String serviceText() {
        double timeSpentDouble = (double) timeSpent() / Math.pow(10, 9);
        String timeSpentString = String.format("%.2f", timeSpentDouble);
        return "Customer (" + getId() + ") spent " + timeSpentString + "s in the service.";
    }
}
