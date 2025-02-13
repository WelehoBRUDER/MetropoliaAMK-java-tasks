package org.controller;

import org.model.Pet;

public class PetController {
    private final int WIDTH;
    private final int HEIGHT;
    private Pet pet;

    public PetController(int w, int h, int size) {
        WIDTH = w;
        HEIGHT = h;
        pet = new Pet(WIDTH / 2 - size / 2, HEIGHT / 2 - size / 2, size);
    }

    public int[] getCoordinates() {
        return pet.getCoordinates();
    }

    public int getSize() {
        return pet.getSize();
    }

    public void move(int dx, int dy) {
        pet.move(dx, dy);
    }
}
