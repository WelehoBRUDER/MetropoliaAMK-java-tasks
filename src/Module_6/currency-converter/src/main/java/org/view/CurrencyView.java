package org.view;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.controller.CurrencyController;

public class CurrencyView extends Application {
    public static CurrencyController controller = new CurrencyController();
    public static final int windowWidth = 600;
    public static final int windowHeight = 450;

    public static Button createButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("button");
        return button;
    }

    public static TextField createInput() {
        TextField input = new TextField();
        input.getStyleClass().add("input");
        return input;
    }

    public static Label createLabel(String text) {
        Label label = new Label(text);
        label.getStyleClass().add("label");
        return label;
    }

    public static Label createLabel(String text, String styleClass) {
        Label label = createLabel(text);
        label.getStyleClass().add(styleClass);
        return label;
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

    public static ComboBox<String> createSelectElement() {
        ComboBox<String> selectElement = new ComboBox<>();
        selectElement.getItems().addAll(controller.getKeys());
        return selectElement;
    }

    public static Pane createCurrencySelection() {
        FlowPane selection = createFlowPane("selection");
        ComboBox<String> fromCurrency = createSelectElement();
        ComboBox<String> toCurrency = createSelectElement();
        fromCurrency.setValue(controller.getFrom());
        toCurrency.setValue(controller.getTo());

        append(selection, fromCurrency, toCurrency);
        return selection;
    }

    // Appends all nodes to the pane (first element in parameters)
    public static void append(Pane pane, Node... nodes) {
        for (Node node : nodes) {
            pane.getChildren().add(node);
        }
    }

    public void start(Stage window) {
        FlowPane mainView = createVerticalFlowPane("main-view");

        // Create selections for currency
        append(mainView, createCurrencySelection());

        Scene view = new Scene(mainView);
        window.setTitle("Currency Converter");
        window.setScene(view);
        // Set window size
        window.setWidth(windowWidth);
        window.setHeight(windowHeight);
        // Show screen and landing page.
        window.show();
    }
}
