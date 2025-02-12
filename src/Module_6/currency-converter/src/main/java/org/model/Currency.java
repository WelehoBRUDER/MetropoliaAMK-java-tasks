package org.model;

public class Currency {
    private final String abbreviation;
    private final String name;
    private final double conversionRate;
    private final String symbol;

    public Currency(String abbreviation, String name, double conversionRate, String symbol) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRate = conversionRate;
        this.symbol = symbol;
    }



    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getConversionRate() {
        return conversionRate;
    }
    
    public String getSymbol() {
        return this.symbol;
    }
}
