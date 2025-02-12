package org.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controller.CurrencyController;

public class CurrencyView extends Application {
    public static CurrencyController controller = new CurrencyController();
    public static final int windowWidth = 600;
    public static final int windowHeight = 450;
    public static TextField conversionResult;

    public static Button createButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("button");
        return button;
    }

    public static TextField createInput() {
        TextField input = new TextField();
        input.getStyleClass().add("input");
        // Prevent non-numeric input
        input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                input.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
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
        VBox currencyLabelA = new VBox();
        VBox currencyLabelB = new VBox();
        ComboBox<String> fromCurrency = createSelectElement();
        ComboBox<String> toCurrency = createSelectElement();
        fromCurrency.setValue(controller.getFrom());
        toCurrency.setValue(controller.getTo());

        Label fromLabel = createLabel(controller.getName(controller.getFrom()));
        Label toLabel = createLabel(controller.getName(controller.getTo()));

        fromCurrency.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.setFrom(fromCurrency.getValue());
                fromLabel.setText(controller.getName(controller.getFrom()));
            }
        });
        toCurrency.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.setTo(toCurrency.getValue());
                toLabel.setText(controller.getName(controller.getTo()));
            }
        });

        append(currencyLabelA, fromLabel, fromCurrency);
        append(currencyLabelB, toLabel, toCurrency);
        append(selection, currencyLabelA, currencyLabelB);
        return selection;
    }

    public static Pane createCurrencyInputs() {
        FlowPane inputs = createFlowPane("inputs");
        TextField start = createInput();
        conversionResult = createInput();

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                controller.setFromCurrency(Double.parseDouble(start.getText()));
            }
        });

        append(inputs, start, conversionResult);
        return inputs;
    }
    public static Button createConvertButton() {
        Button btn = createButton("Convert");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                conversion();
            }
        });
        return btn;
    }

    public static void conversion() {
        controller.convert();
        conversionResult.setText(String.format("%.4f", controller.getToCurrency()));
    }

    // Appends all nodes to the pane (first element in parameters)
    public static void append(Pane pane, Node... nodes) {
        for (Node node : nodes) {
            pane.getChildren().add(node);
        }
    }

    public void start(Stage window) {
        FlowPane mainView = createVerticalFlowPane("main-view");

        // Create inputs for currency
        append(mainView, createCurrencyInputs());

        // Create selections for currency
        append(mainView, createCurrencySelection());

        // Create conversion button
        append(mainView, createButton("Convert"));

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
