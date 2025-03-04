package org.controller;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.util.Duration;
import org.dao.CurrencyDao;
import org.entity.Currency;

public class AddCurrencyController {
    @FXML
    private TextField abbreviationField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField conversionRateField;
    @FXML
    private TextField symbolField;
    @FXML
    private Label resultLabel;

    private CurrencyController mainController;

    public void setMainController(CurrencyController mainController) {
        this.mainController = mainController;
    }

    public void initialize() {
        abbreviationField.setText("");
        nameField.setText("");
        conversionRateField.setText("1");
        symbolField.setText("");
        resultLabel.setText("");
    }

    public void sanitizeConversion() {
        String text = conversionRateField.getText();
        if (!text.matches("\\d*\\.?\\d*")) {
            conversionRateField.setText(text.replaceAll("[^\\d.]", ""));
        }
    }

    public String getConversion() {
        String conversion = conversionRateField.getText();
        if (conversion.isEmpty()) {
            conversion = "1";
        }
        return conversion;
    }

    @FXML
    public void displaySuccess(String message) {
        resultLabel.setText(message);
        resultLabel.styleProperty().set("-fx-text-fill: green");
    }

    @FXML
    public void displayFailure(String message) {
        resultLabel.setText(message);
        resultLabel.styleProperty().set("-fx-text-fill: red");
    }

    public void close() {
        abbreviationField.getScene().getWindow().hide();
    }

    public void submit() throws Exception {
        String abbreviation = abbreviationField.getText();
        String name = nameField.getText();
        double conversionRate = Double.parseDouble(getConversion());
        String symbol = symbolField.getText();
        Currency curr = new Currency(abbreviation, name, conversionRate, symbol);
        CurrencyDao dao = new CurrencyDao();
        String result = dao.persist(curr);
        String successOrFail = result.substring(0, 1);
        if (successOrFail.equals("s")) {
            displaySuccess(result.substring(1));
            // Transition to the main view after 2 seconds
            PauseTransition pause = new PauseTransition(Duration.millis(2000));
            pause.setOnFinished(event -> close());
            pause.play();
        } else {
            displayFailure(result.substring(1));
        }
    }
}
