package org.controller;

import org.model.Currency;
import java.util.HashMap;

public class CurrencyController {
    private HashMap<String, Currency> currencies = new HashMap<>();
    private double fromCurrency = 0;
    private double toCurrency = 0;
    private String from = "EUR";
    private String to = "USD";

    public CurrencyController() {
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

    public double getToCurrency() {
        return this.toCurrency;
    }

    public double getFromCurrency() {
        return this.fromCurrency;
    }

    public void setFrom(String abrv) {
        this.from = abrv;
    }
    public void setTo(String abrv) {
        this.to = abrv;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return to;
    }

    public void convert() {
        Currency conversion = currencies.get(from);
        Currency result = currencies.get(to);
        double rate = result.getConversionRate() / conversion.getConversionRate();
        System.out.println(rate);
        System.out.println("fromCurrency: " + fromCurrency);
        setToCurrency(fromCurrency / rate);
        System.out.println(toCurrency);
    }
}
