package Project_1_2;

import java.util.PriorityQueue;

public class Simulation {
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
            // Partly TASK 3
            System.out.println("End time: " + event.getEndTime() + " Type: " + event.getType());
        }
    }
}
