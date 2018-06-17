package com.kapitanov;

import java.util.ArrayList;
import java.util.List;

public class Branch {
    private String name;
    private List<Customer> customerList;

    public Branch(String name) {
        this.name = name.toLowerCase();
        this.customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        int customerIndex = getCustomerID(customer.getName());
        if (customerIndex < 0) {
            this.customerList.add(customer);
            System.out.println("Customer " + customer.getName() + " added");
        } else {
            System.out.println("Customer with that name already exists");
        }

    }

    public List<Customer> getCustomerList() {
        return this.customerList;
    }

    public void addTransaction(String customer, double amount) {
         if (getCustomerID(customer)  >= 0) {
             int index = getCustomerID(customer);
             this.customerList.get(index).executeTransaction(amount);
         } else {
             System.out.println("Could not find such customer");
         }
    }

    public int getCustomerID(String name) {
        for (int i = 0;i < this.customerList.size();i++) {
            if (this.customerList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String getName() {
        return this.name.toLowerCase();
    }

    public void viewCustomerTransactions(String customerName) {
        int customerIndex = getCustomerID(customerName);
            if (customerIndex >= 0) {
                for (double transaction : this.customerList.get(customerIndex).viewTransactions()) {
                    System.out.println(transaction);
                }
            } else {
                System.out.println("No customer transactions found");
            }
        }
}
