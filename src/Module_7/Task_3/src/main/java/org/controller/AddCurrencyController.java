package org.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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

    public void initialize() {
        abbreviationField.setText("");
        nameField.setText("");
        conversionRateField.setText("1");
        symbolField.setText("");
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

    public void close() {
        abbreviationField.getScene().getWindow().hide();
    }
    public void submit() {
        String abbreviation = abbreviationField.getText();
        String name = nameField.getText();
        double conversionRate = Double.parseDouble(getConversion());
        String symbol = symbolField.getText();
        Currency curr = new Currency(abbreviation, name, conversionRate, symbol);
        CurrencyDao dao = new CurrencyDao();
        String result = dao.persist(curr);
        System.out.println(result);
    }
}
