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
        PriorityQueue<Event> pq = new PriorityQueue<Event>();
        pq.add(new Event(3, 5));
        pq.add(new Event(1, 9));
        pq.add(new Event(5, 1));
        pq.add(new Event(7, 6));
        pq.poll();
    }
}

