package org.view;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controller.PetController;

public class PetView extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int SPEED = 6;
    private static final int SIZE = 70;
    private static final String PET_IMAGE = "/wolf.png";
    private static final Canvas canvas = new Canvas(WIDTH, HEIGHT);
    private static final GraphicsContext ctx = canvas.getGraphicsContext2D();
    private static final PetController petController = new PetController(WIDTH, HEIGHT, SIZE, SPEED);
    private static final int[] mouse = new int[2];
    private static boolean keepMoving = true;

    public static int[] getWindowSize() {
        return new int[]{WIDTH, HEIGHT};
    }

    public static void setKeepMoving(boolean keepMoving) {
        PetView.keepMoving = keepMoving;
    }

    public static boolean getKeepMoving() {
        return keepMoving;
    }

    public static Canvas getCanvas() {
        return canvas;
    }

    // Draw the pet to its current coordinates.
    public static void drawPet() {
        // Get the pet's current coordinates and size.
        int x = petController.getX();
        int y = petController.getY();
        int size = petController.getSize();

        // Clear the canvas and draw the pet to its new coordinates.
        ctx.clearRect(0, 0, WIDTH, HEIGHT);
        Image img = new Image(String.valueOf(PetView.class.getResource(PET_IMAGE)));
        ctx.drawImage(img, x, y, size, size);
    }

    public void start(Stage window) {
        // Set up the window and canvas
        StackPane root = new StackPane(getCanvas());
        Scene scene = new Scene(root);

        // Set title and scene
        window.setTitle("Virtual Pet");
        window.setScene(scene);

        // Set window size and properties
        int[] windowSize = getWindowSize();
        window.setWidth(windowSize[0]);
        window.setHeight(windowSize[1]);
        window.setResizable(false); // Prevent resizing the window.
        window.show();

        // Update cursor position when mouse moves.
        getCanvas().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_MOVED, e -> {
            mouse[0] = (int) e.getX();
            mouse[1] = (int) e.getY();
        });

        // Order the pet to start moving when mouse enters the window.
        getCanvas().addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, e -> {
            setKeepMoving(true);
        });

        // Order the pet to stop moving when mouse exits the window.
        getCanvas().addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, e -> {
            setKeepMoving(false);
        });

        // Create interval that draws the pet to its current coordinates.
        Timeline petMoving = new Timeline(new KeyFrame(Duration.millis((double) 1000 / 60), e -> {
            if (!getKeepMoving()) {
                return;
            }
            // Calculate the next step for the pet to take towards the mouse cursor.
            petController.calculatePetPath(mouse[0], mouse[1]);
            // Draw the pet to its new coordinates.
            drawPet();
        }));
        // Set the interval to run indefinitely and start it.
        petMoving.setCycleCount(Timeline.INDEFINITE);
        petMoving.play();
    }
}
