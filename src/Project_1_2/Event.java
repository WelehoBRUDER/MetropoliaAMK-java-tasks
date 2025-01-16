package Project_1_2;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Event implements Comparable<Event> {
    // TASK 3 - ENUM
    public enum EventType {
        ARRIVAL, EXIT
    }

    private int startTime;
    private int endTime;
    private int duration;
    // TASK 3 - ENUM
    private EventType type;

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
        this.endTime = startTime + duration;
    }

    public int getEndTime() {
        return endTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // TASK 3 - ENUM
    public EventType getType() {
        return type;
    }


    public Event(int startTime, int duration) {
        this.setDuration(duration);
        this.setStartTime(startTime);
        // TASK 3 - ENUM
        this.type = EventType.ARRIVAL;
    }

    public int compareTo(Event e) {
        return Integer.compare(this.getEndTime(), e.getEndTime());
    }

    public static void main(String[] args) {
        PriorityQueue<Event> eventList = new PriorityQueue<Event>();
        eventList.add(new Event(3, 5));
        eventList.add(new Event(1, 9));
        eventList.add(new Event(5, 1));
        eventList.add(new Event(7, 6));
        eventList.poll();
        // Make copy of eventList to iterate through without altering the original list
        PriorityQueue<Event> eventListCopy = new PriorityQueue<>(eventList);
        // Iterate through the copy using .poll()
        while (!eventListCopy.isEmpty()) {
            Event event = eventListCopy.poll();
            System.out.println("End time: " + event.getEndTime() + " Type: " + event.getType());
        }
    }
}

