package org.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.controller.DictionaryController;
import org.model.Dictionary;


public class DictionaryView extends Application {
    public void start(Stage window) {
        DictionaryController controller = new DictionaryController(new Dictionary());
        controller.addWord("hello", "used as a greeting or to begin a conversation");
        controller.addWord("world", "the earth, together with all of its countries and peoples");
        Label text = new Label("Test");
        Button button = new Button("Search");
        TextField input = new TextField();

        FlowPane mainView = new FlowPane(Orientation.VERTICAL);
        FlowPane search = new FlowPane();
        FlowPane result = new FlowPane();
        search.getChildren().add(input);
        search.getChildren().add(button);
        result.getChildren().add(text);
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String found = controller.searchForWord(input.getText());
                text.setText(found);
            }
        });
        mainView.getChildren().add(search);
        mainView.getChildren().add(result);
        Scene view = new Scene(mainView);
        window.setTitle("Virtual Dictionary");
        window.setScene(view);
        window.show();
    }
}