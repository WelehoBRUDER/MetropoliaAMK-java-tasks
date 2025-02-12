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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controller.DictionaryController;
import org.model.Dictionary;
import org.model.Word;

import java.util.ArrayList;


public class DictionaryView extends Application {
    public static final DictionaryController controller = new DictionaryController(new Dictionary());
    public static TextField input;
    public static Label text;
    public static Pane result;
    public final static int windowWidth = 600;
    public final static int windowHeight = 550;

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

    public static Label createLabel(String text, String styleClass) {
        Label label = createLabel(text);
        label.getStyleClass().add(styleClass);
        return label;
    }

    // Generic search call for events
    public static void doSearchQuery(String query) {
        clear(result);
        ArrayList<Word> found = controller.searchForWord(query);
        if (found.isEmpty()) {
            append(result, new Label("No results found for '" + query + "'"));
        } else {
            for (Word word : found) {
                String title = word.getTitle();
                Hyperlink link = clickableTitle(title);
                append(result, link);
            }
        }
    }

    public static Button createSearchButton() {
        Button button = createButton("Search");
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                doSearchQuery(input.getText());
            }
        });
        return button;
    }

    public static Hyperlink clickableTitle(String title) {
        Hyperlink link = new Hyperlink(title);
        link.getStyleClass().add("dict-link");
        link.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                wordView(title);
            }
        });
        return link;
    }

    // Creates the layout for displaying information about a single word
    public static void wordView(String word) {
        clear(result);
        ArrayList<Word> found = controller.searchForWord(word);
        // Check if the word exists to prevent funny business
        if (!found.isEmpty()) {
            // If it exists, it will always be at index 0.
            Word current = found.get(0);
            // Create labels and wrappers for the elements to be displayed
            Label title = createLabel(current.getTitle(), "word-title");
            Label definition = createLabel(current.getDefinition(), "word-definition");
            Pane examples = createVBox("examples");
            Label examplesTitle = createLabel("Examples:");
            append(examples, examplesTitle);
            // Loop through examples list and create labels for each of them.
            for (String example : current.getExamples()) {
                append(examples, createLabel(example));
            }

            // Append all elements to the result pane.
            append(result, title, definition, examples);
        }
    }

    public static FlowPane createFlowPane(String styleClass) {
        FlowPane pane = new FlowPane();
        pane.getStyleClass().add(styleClass);
        pane.getStyleClass().add("dict-pane");
        return pane;
    }

    public static VBox createVBox(String styleClass) {
        VBox box = new VBox();
        box.getStyleClass().add(styleClass);
        box.getStyleClass().add("dict-vbox");
        return box;
    }

    public static FlowPane createVerticalFlowPane(String styleClass) {
        FlowPane pane = new FlowPane(Orientation.VERTICAL);
        pane.getStyleClass().add(styleClass);
        pane.getStyleClass().add("dict-pane");
        return pane;
    }

    // Appends all nodes to the pane (first element in parameters)
    public static void append(Pane pane, Node... nodes) {
        for (Node node : nodes) {
            pane.getChildren().add(node);
        }
    }

    public static void clear(Pane pane) {
        pane.getChildren().clear();
    }

    public void start(Stage window) {

        // Create text and input
        Button button = DictionaryView.createSearchButton();
        text = DictionaryView.createLabel("");
        input = DictionaryView.createInput();
        // Add event handler to allow using enter for search
        input.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                // Check if the keyCode is equal to "ENTER"
                if (keyEvent.getCode().toString().equals("ENTER")) {
                    doSearchQuery(input.getText());
                }
            }
        });

        // Create search and result panes
        FlowPane mainView = DictionaryView.createVerticalFlowPane("main-view");
        FlowPane search = DictionaryView.createFlowPane("search-pane");
        result = DictionaryView.createVerticalFlowPane("result-pane");

        // Position elements
        search.setTranslateX(50);
        search.setTranslateY(25);
        result.setTranslateX(50);
        result.setTranslateY(25);

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
        // Set window size
        window.setWidth(windowWidth);
        window.setHeight(windowHeight);
        // Show screen and landing page.
        window.show();
        doSearchQuery(""); // Show all possible words upon launching the dictionary
    }
}