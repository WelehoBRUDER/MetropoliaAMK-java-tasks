package org.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.controller.DictionaryController;
import org.model.Dictionary;


public class DictionaryView extends Application {
    public static final DictionaryController controller = new DictionaryController(new Dictionary());
    public static TextField input;
    public static Label text;
    public static FlowPane result;

    public static Button createButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("dict-button");
        return button;
    }

    public static TextField createInput() {
        TextField input = new TextField();
        input.getStyleClass().add("dict-input");
        return input;
    }

    public static Label createLabel(String text) {
        Label label = new Label(text);
        label.getStyleClass().add("dict-label");
        return label;
    }

    public static Button createSearchButton() {
        Button button = createButton("Search");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String found = controller.searchForWord(input.getText());
                text.setText(found);
            }
        });
        return button;
    }

    public static FlowPane createFlowPane(String styleClass) {
        FlowPane pane = new FlowPane();
        pane.getStyleClass().add(styleClass);
        pane.getStyleClass().add("dict-pane");
        return pane;
    }

    public static FlowPane createVerticalFlowPane(String styleClass) {
        FlowPane pane = new FlowPane(Orientation.VERTICAL);
        pane.getStyleClass().add(styleClass);
        pane.getStyleClass().add("dict-pane");
        return pane;
    }

    // Appends all nodes to the pane (first element in parameters)
    public static void append(FlowPane pane, Node... nodes) {
        for (Node node : nodes) {
            pane.getChildren().add(node);
        }
    }

    public void start(Stage window) {

        // Create text and input
        Button button = DictionaryView.createSearchButton();
        text = DictionaryView.createLabel("");
        input = DictionaryView.createInput();

        // Create search and result panes
        FlowPane mainView = DictionaryView.createVerticalFlowPane("main-view");
        FlowPane search = DictionaryView.createFlowPane("search-pane");
        result = DictionaryView.createFlowPane("result-pane");

        // Append elements to panes
        DictionaryView.append(search, input, button);
        DictionaryView.append(result, text);

        // Append panes together
        DictionaryView.append(mainView, search, result);

        // Create the scene and load styles
        Scene view = new Scene(mainView);
        view.getStylesheets().add(getClass().getResource("/dictionary.css").toExternalForm());
        window.setTitle("Virtual Dictionary");
        window.setScene(view);
        window.show();
    }
}