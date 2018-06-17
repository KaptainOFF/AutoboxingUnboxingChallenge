package com.kapitanov;

import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Branch> branches;

    public Bank() {
        this.branches = new ArrayList<>();
    }

    public void addBranch(Branch branch) {
        if (getBranchId(branch.getName().toLowerCase()) < 0) {
            this.branches.add(branch);
        } else {
            System.out.println("Error adding branch");
        }
    }

    public void listAllCustomers(String branchName) {
        int indexOfBranch = getBranchId(branchName.toLowerCase());
        if ( indexOfBranch >= 0) {
            for (Customer customer : this.branches.get(indexOfBranch).getCustomerList()) {
                System.out.println(customer.getName());
            }
        }
    }

    private int getBranchId(String branchName) {
        for (int i = 0; i < this.branches.size(); i++) {
            if (this.branches.get(i).getName().equals(branchName.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    public void addCustomerToBranch(String branch, Customer customer) {
        branch = branch.toLowerCase();
        int indexOfBranch = getBranchId(branch);
        if (indexOfBranch >= 0) {
            this.branches.get(indexOfBranch).addCustomer(customer);
        } else {
            System.out.println("Branch does not exist");
        }
    }

    public void addTransactionToCustomer(String branch, String customer, double transaction) {
        int indexOfBranch = getBranchId(branch);
        if (indexOfBranch >= 0) {
            this.branches.get(indexOfBranch).addTransaction(customer, transaction);
        }
    }

    public void listAllBranches() {
        if (this.branches.size() == 0) {
            System.out.println("There are no branches");
        } else {
            for (Branch branch : this.branches) {
                System.out.println(branch.getName());
            }
        }
    }

    public void viewCustomerTransactions(String branch, String customer) {
        branch = branch.toLowerCase();
        int indexOfBranch = getBranchId(branch);
        if (indexOfBranch >= 0) {
            this.branches.get(indexOfBranch).viewCustomerTransactions(customer);
        }
    }
}
