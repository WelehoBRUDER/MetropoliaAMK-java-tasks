package org.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddCurrencyController {
    @FXML
    private TextField abbreviationField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField conversionRateField;
    @FXML
    private TextField symbolField;

    public void initialize() {
        abbreviationField.setText("");
        nameField.setText("");
        conversionRateField.setText("");
        symbolField.setText("");
    }

    public void sanitizeConversion() {
        String text = conversionRateField.getText();
        if (!text.matches("\\d*\\.?\\d*")) {
            conversionRateField.setText("");
        }
    }
}
