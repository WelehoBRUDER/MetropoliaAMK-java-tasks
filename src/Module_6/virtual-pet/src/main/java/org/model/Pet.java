package org.model;

public class Pet {
    private int x;
    private int y;
    private int size;

    public Pet(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public int[] getCoordinates() {
        return new int[] {x, y};
    }

    public int getSize() {
        return size;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
