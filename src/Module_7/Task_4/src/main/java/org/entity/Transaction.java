package org.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    @ManyToOne
    private Currency source;
    @ManyToOne
    private Currency target;

    public Transaction(double amount, Currency source, Currency target) {
        super();
        this.amount = amount;
        this.source = source;
        this.target = target;
    }

    public Transaction() {
    }


    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
