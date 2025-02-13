package org.controller;

import org.model.Pet;

public class PetController {
    private final int WIDTH;
    private final int HEIGHT;
    private Pet pet;

    public PetController(int w, int h, int size, int speed) {
        WIDTH = w;
        HEIGHT = h;
        // Spawns the pet in the middle of the screen
        pet = new Pet(WIDTH / 2 - size / 2, HEIGHT / 2 - size / 2, speed, size);
    }

    public int getX() {
        return pet.getX();
    }

    public int getY() {
        return pet.getY();
    }

    public int getSize() {
        return pet.getSize();
    }

    // Calculates the next step for the pet to take towards the mouse cursor.
    public void calculatePetPath(int x, int y) {
        // Find the coordinate that places the pet in the center of the mouse cursor.
        int midX = x - pet.getSize() / 2;
        int midY = y - pet.getSize() / 2;
        // Prevent the pet from moving outside the window.
        if (midX < 0 || midX > WIDTH || midY < 0 || midY > HEIGHT) {
            return;
        }
        // Calculate delta x and y
        int dx = midX - pet.getX();
        int dy = midY - pet.getY();
        // Calculate the distance between the pet and the mouse cursor.
        double distance = Math.sqrt(dx * dx + dy * dy);
        // Move the pet towards the mouse cursor if it is not already there.
        if (distance > 0) {
            // Move the pet a maximum of its speed or the distance to the mouse cursor.
            int steps = (int) Math.min(pet.getSpeed(), distance);
            pet.move((int) (dx / distance * steps), (int) (dy / distance * steps));
        }
    }
}
