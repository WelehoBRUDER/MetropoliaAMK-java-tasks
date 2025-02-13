package org.view;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.controller.PetController;

public class PetView extends Application {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;
    private final Canvas canvas = new Canvas(WIDTH, HEIGHT);
    private final GraphicsContext ctx = canvas.getGraphicsContext2D();
    private PetController petController = new PetController(WIDTH, HEIGHT, 20);

    public int[] getWindowSize() {
        return new int[]{WIDTH, HEIGHT};
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void drawPet() {
        int[] pos = petController.getCoordinates();
        int size = petController.getSize();
        ctx.clearRect(0, 0, WIDTH, HEIGHT);
        ctx.fillOval(pos[0], pos[1], 20, 20);
    }

    public void start(Stage window) {
        PetView petView = new PetView();
        StackPane root = new StackPane(petView.getCanvas());
        Scene scene = new Scene(root);
        window.setTitle("Virtual Pet");
        window.setScene(scene);
        int[] windowSize = petView.getWindowSize();
        window.setWidth(windowSize[0]);
        window.setHeight(windowSize[1]);
        window.show();

        petView.drawPet();

    }
}
