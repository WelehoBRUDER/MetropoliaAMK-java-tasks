package org.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    private String abbreviation;
    private String name;
    @Column (name = "conversion")
    private double conversionRate;
    private String symbol;

    public Currency(String abbreviation, String name, double conversionRate, String symbol) {
        super();
        this.abbreviation = abbreviation;
        this.name = name;
        this.conversionRate = conversionRate;
        this.symbol = symbol;
    }

    public Currency() {
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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
