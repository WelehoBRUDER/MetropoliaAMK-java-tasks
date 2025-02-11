package org.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.controller.DictionaryController;
import org.model.Dictionary;
import org.model.Word;

import java.util.ArrayList;


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
                clear(result);
                ArrayList<Word> found = controller.searchForWord(input.getText());
                if (found.isEmpty()) {
                    append(result, new Label("No results found for '" + input.getText() + "'"));
                } else {
                    for (Word word : found) {
                        String title = word.getTitle();
                        Hyperlink link = clickableTitle(title);
                        append(result, link);
                    }
                }
            }
        });
        return button;
    }

    public static Hyperlink clickableTitle(String title) {
        Hyperlink link = new Hyperlink(title);
        link.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                wordView(title);
            }
        });
        return link;
    }

    public static void wordView(String word) {
        clear(result);
        ArrayList<Word> found = controller.searchForWord(word);
        if (!found.isEmpty()) {
            Word current = found.get(0);
            Label title = createLabel(current.getTitle());
            Label definition = createLabel(current.getDefinition());
            System.out.println(current.getTitle());
            System.out.println(current.getDefinition());
            FlowPane examples = createFlowPane("examples");
            Label examplesTitle = createLabel("Examples:");
            append(examples, examplesTitle);
            for (String example : current.getExamples()) {
                append(examples, createLabel(example));
            }

            append(result, title, definition, examples);
        }
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

    public static void clear(FlowPane pane) {
        pane.getChildren().clear();
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