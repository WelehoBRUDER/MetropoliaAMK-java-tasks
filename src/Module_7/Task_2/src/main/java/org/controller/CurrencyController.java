package org.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.model.Currency;
import java.util.HashMap;

public class CurrencyController {
    private HashMap<String, Currency> currencies = new HashMap<>();
    private double fromCurrency = 0;
    private double toCurrency = 0;
    private String from = "EUR";
    private String to = "USD";

    @FXML
    private Label currencyNameA;
    @FXML
    private Label currencyNameB;
    @FXML
    private Label currencySymbolA;
    @FXML
    private Label currencySymbolB;
    @FXML
    private ComboBox<String> currencySelectA;
    @FXML
    private ComboBox<String> currencySelectB;
    @FXML
    private TextField currencyInputA;
    @FXML
    private TextField currencyInputB;

    public void initialize() {
        currencies.put("EUR", new Currency("EUR", "Euro", 1.04, "€"));
        currencies.put("USD", new Currency("USD", "US Dollar", 1, "$"));
        currencies.put("PLN", new Currency("PLN", "Polish Zloty", 0.25, "zł"));
        currencies.put("JPY", new Currency("JPY", "Japanese Yen", 0.0065, "¥"));
        currencies.put("RUB", new Currency("RUB", "Russian Ruble", 0.011, "₽"));
        currencies.put("CNY", new Currency("CNY", "Chinese Yuan", 0.14, "¥"));
        currencies.put("INR", new Currency("INR", "Indian Rupee", 0.012, "₹"));
        currencies.put("GBP", new Currency("GBP", "British Pound", 1.25, "£"));
        currencies.put("AUD", new Currency("AUD", "Australian Dollar", 0.72, "$"));
        currencies.put("CAD", new Currency("CAD", "Canadian Dollar", 0.74, "$"));
        currencies.put("BRL", new Currency("BRL", "Brazilian Real", 0.19, "R$"));
        currencies.put("MXN", new Currency("MXN", "Mexican Peso", 0.051, "$"));
        currencies.put("KRW", new Currency("KRW", "South Korean Won", 0.00085, "₩"));
        currencies.put("SEK", new Currency("SEK", "Swedish Krona", 0.11, "kr"));
        createCurrencySelections();
    }

    @FXML
    public void createCurrencySelections() {
        currencySelectA.getItems().addAll(getKeys());
        currencySelectB.getItems().addAll(getKeys());
        currencySelectA.setValue(from);
        currencySelectB.setValue(to);
        updateDisplayedNames();
    }

    @FXML
    public void updateDisplayedNames() {
        currencyNameA.setText(getName(from));
        currencyNameB.setText(getName(to));
        currencySymbolA.setText(currencies.get(from).getSymbol());
        currencySymbolB.setText(currencies.get(to).getSymbol());
    }

    public String[] getKeys() {
        return this.currencies.keySet().toArray(new String[0]);
    }

    public Currency getCurrency(String abrv) {
        return this.currencies.get(abrv);
    }

    public String getName(String abrv) {
        return this.currencies.get(abrv).getName();
    }

    public void setFromCurrency(double fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setToCurrency(double toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setFrom() {
        this.from = currencySelectA.getValue();
        updateDisplayedNames();
    }
    public void setTo() {
        this.to = currencySelectB.getValue();
        updateDisplayedNames();
    }

    public void convert() {
        Currency conversion = currencies.get(from);
        Currency result = currencies.get(to);
        double rate = result.getConversionRate() / conversion.getConversionRate();
        setToCurrency(fromCurrency / rate);
        updateCurrencyResult();
    }

    @FXML
    public void updateCurrencyResult() {
        currencyInputB.setText(String.format("%.2f", toCurrency));
    }

    public void tryToUpdateCurrency() {
        // Filter out non-numeric characters
        if (!currencyInputA.getText().matches("\\d*\\.?\\d*")) {
            currencyInputA.setText(currencyInputA.getText().replaceAll("[^\\d.]", ""));
        }
        // Prevent attempting to convert empty string to a double
        if (currencyInputA.getText().isEmpty()) {
            setFromCurrency(0);
        } else {
            // Update the value in the controller once the input is sanitized
            setFromCurrency(Double.parseDouble(currencyInputA.getText()));
        }
    }
}
