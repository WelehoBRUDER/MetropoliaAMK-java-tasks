package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class HelloWorldApplication extends Application {
    public void start(Stage window) {
        Label text = new Label("Hello World!");
        Button button = new Button("Click me!");
        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(text);
        componentGroup.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                text.setText("Hello Universe!");
            }
        });
        Scene view = new Scene(componentGroup);
        window.setTitle("My Greeting Application");
        window.setScene(view);
        window.show();
    }
}