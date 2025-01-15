package Project_1_2;

import java.util.PriorityQueue;

public class Event implements Comparable<Event> {
    private int startTime;
    private int endTime;
    private int duration;

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

    public Event(int startTime, int duration) {
        this.setDuration(duration);
        this.setStartTime(startTime);
    }

    public int compareTo(Event e) {
        return Integer.compare(this.getEndTime(), e.getEndTime());
    }

    public static void main(String[] args) {
        Event e1 = new Event(3, 5);
        Event e2 = new Event(1, 9);
        Event e3 = new Event(5, 1);
        PriorityQueue<Event> pq = new PriorityQueue<Event>();
        pq.add(e1);
        pq.add(e2);
        pq.add(e3);
        pq.poll();
        for (Event e : pq) {
            System.out.println(e.getEndTime());
        }
    }
}

