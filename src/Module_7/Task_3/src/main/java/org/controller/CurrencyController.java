package org.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.dao.CurrencyDao;
import org.entity.Currency;
import org.view.AddCurrencyView;
import org.view.CurrencyView;

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
    @FXML
    private Button convertButton;
    @FXML
    private Label errorMessage;

    public void update() {
        currencies.clear();
        initialize();
    }

    public void initialize() {
        CurrencyDao dao = new CurrencyDao();
        for (Currency currency : dao.findAll()) {
            currencies.put(currency.getAbbreviation(), currency);
        }
        if (currencies.isEmpty()) {
            convertButton.setDisable(true);
            currencySelectA.setDisable(true);
            currencySelectB.setDisable(true);
            currencyInputA.setDisable(true);
            currencyInputB.setDisable(true);
            errorMessage.setText("FAILED DATABASE CONNECTION");
        } else {
        createCurrencySelections();
        }
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

    @FXML
    public void addNewCurrency() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/add_currency_view.fxml"));
        Parent root = fxmlLoader.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setOnHidden(event -> update());
        stage.show();
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
