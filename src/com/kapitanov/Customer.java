package com.kapitanov;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Double> transactions;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public void executeTransaction(double transaction) {
        this.transactions.add(transaction);
    }

    public List<Double> viewTransactions() {
        return this.transactions;
    }
}
