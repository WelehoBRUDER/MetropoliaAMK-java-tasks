package org.model;

public class Pet {
    private int x;
    private int y;
    private int speed;
    private int size;

    public Pet(int x, int y, int speed, int size) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.setX(x + dx);
        this.setY(y += dy);
    }
}
