package org.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.controller.CurrencyController;

public class CurrencyView extends Application {
    public static CurrencyController controller = new CurrencyController();
    public static final int windowWidth = 500;
    public static final int windowHeight = 200;
    public static TextField conversionResult;

    private static Label fromSymbol;
    private static Label toSymbol;

    public static Button createButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("button");
        return button;
    }

    public static TextField createInput(Boolean interactable) {
        TextField input = new TextField();
        input.getStyleClass().add("input");
        input.setText("0");
        // Prevent non-numeric input
        if (interactable) {
            input.textProperty().addListener((observable, oldValue, newValue) -> {
                // Filter out non-numeric characters
                if (!newValue.matches("\\d*\\.?\\d*")) {
                    input.setText(newValue.replaceAll("[^\\d.]", ""));
                }
                // Prevent attempting to convert empty string to a double
                if (input.getText().isEmpty()) {
                    controller.setFromCurrency(0);
                } else {
                    // Update the value in the controller once the input is sanitized
                    controller.setFromCurrency(Double.parseDouble(input.getText()));
                }
            });
        }
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
        pane.getStyleClass().add("pane");
        return pane;
    }

    public static FlowPane createVerticalFlowPane(String styleClass) {
        FlowPane pane = new FlowPane(Orientation.VERTICAL);
        pane.getStyleClass().add(styleClass);
        pane.getStyleClass().add("pane");
        return pane;
    }

    public static ComboBox<String> createSelectElement() {
        ComboBox<String> selectElement = new ComboBox<>();
        selectElement.getItems().addAll(controller.getKeys());
        selectElement.getStyleClass().add("select");
        return selectElement;
    }

    // Creates the currency selection dropdowns
    public static Pane createCurrencySelection() {
        HBox selection = new HBox();
        selection.setPrefWidth(windowWidth - 20);
        selection.setAlignment(Pos.CENTER); // Optional: to center vertically
        selection.setSpacing(10);
        // Create containers for both currencies
        VBox currencyLabelA = new VBox();
        VBox currencyLabelB = new VBox();
        currencyLabelA.setAlignment(Pos.CENTER); // Optional: to center vertically
        currencyLabelA.setSpacing(2);
        currencyLabelB.setAlignment(Pos.CENTER); // Optional: to center vertically
        currencyLabelB.setSpacing(2);
        Label arrow = createLabel("→", "arrow-right");

        // Create dropdown menus for both currency sides
        ComboBox<String> fromCurrency = createSelectElement();
        ComboBox<String> toCurrency = createSelectElement();
        fromCurrency.setValue(controller.getFrom());
        toCurrency.setValue(controller.getTo());

        // Create labels that display the selected currency's name
        Label fromLabel = createLabel(controller.getName(controller.getFrom()), "currency-label");
        Label toLabel = createLabel(controller.getName(controller.getTo()), "currency-label");

        // Handle currency selection changes
        fromCurrency.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.setFrom(fromCurrency.getValue());
                fromLabel.setText(controller.getName(controller.getFrom()));
                updateSymbols();
            }
        });
        toCurrency.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.setTo(toCurrency.getValue());
                toLabel.setText(controller.getName(controller.getTo()));
                updateSymbols();
            }
        });

        append(currencyLabelA, fromLabel, fromCurrency);
        append(currencyLabelB, toLabel, toCurrency);
        append(selection, currencyLabelA, arrow, currencyLabelB);
        return selection;
    }

    // Updates the currency symbols based on the selected currency
    public static void updateSymbols() {
        fromSymbol.setText(controller.getCurrency(controller.getFrom()).getSymbol());
        toSymbol.setText(controller.getCurrency(controller.getTo()).getSymbol());
    }

    // Creates the main layout where the user can type in the amount to convert and see the result
    public static Pane createCurrencyInputs() {
        // Create main container and inputs
        HBox inputs = new HBox();
        inputs.setPrefWidth(windowWidth - 20);
        inputs.setAlignment(Pos.CENTER); // Optional: to center vertically
        inputs.setSpacing(10);
        TextField start = createInput(true);
        conversionResult = createInput(false);

        // Create containers for input and symbol
        StackPane startContainer = new StackPane();
        StackPane conversionContainer = new StackPane();

        // Create currency symbols
        fromSymbol = createLabel(controller.getCurrency(controller.getFrom()).getSymbol(), "symbol");
        toSymbol = createLabel(controller.getCurrency(controller.getTo()).getSymbol(), "symbol");

        // Ensure currency symbols are always on top
        fromSymbol.toFront();
        toSymbol.toFront();

        // Position currency symbols to the rightmost edge of the input field
        fromSymbol.translateXProperty().bind(start.layoutXProperty().add(70));
        toSymbol.translateXProperty().bind(conversionResult.layoutXProperty().add(70));

        // Set padding on the input to prevent overlap between it and the currency symbol
        start.setPadding(new Insets(5, 5, 5, 20));
        conversionResult.setPadding(new Insets(5, 5, 5, 20));

        // Append everything together
        append(startContainer, start, fromSymbol);
        append(conversionContainer, conversionResult, toSymbol);

        append(inputs, startContainer, conversionContainer);
        return inputs;
    }

    // Creates the button that triggers the currency conversion
    public static HBox createConvertButton() {
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        Button btn = createButton("Convert");

        // Add click event to perform the conversion
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                conversion();
            }
        });

        append(container, btn);
        return container;
    }

    // Calls the conversion method in the controller and updates the result field
    public static void conversion() {
        controller.convert();
        conversionResult.setText(String.format("%.2f", controller.getToCurrency()));
    }

    // Appends all nodes to the pane (first element in parameters)
    public static void append(Pane pane, Node... nodes) {
        for (Node node : nodes) {
            pane.getChildren().add(node);
        }
    }

    public void start(Stage window) {
        // Create main view
        FlowPane mainView = createVerticalFlowPane("main-view");

        // Create selections for currency
        append(mainView, createCurrencySelection());

        // Create inputs for currency
        append(mainView, createCurrencyInputs());

        // Create conversion button
        append(mainView, createConvertButton());

        // Add margin between elements
        mainView.setVgap(15);

        // Create scene and set styles
        Scene view = new Scene(mainView);
        view.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        window.setTitle("Currency Converter");
        window.setScene(view);

        // Set window size
        window.setWidth(windowWidth);
        window.setHeight(windowHeight);

        // Show screen and landing page.
        window.show();
    }
}
