package com.kapitanov;

import java.util.Scanner;

public class Main {
    private static Bank DeutscheBank = new Bank();
    private static boolean quit = false;
    private  static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
        while(!quit) {
            System.out.print("Please choose an option (1 to see options): ");
            int choice = scanner.nextInt() - 1;
            scanner.nextLine();
            switch (choice) {
                case 0:
                    printMenu();
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    listAllBranches();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    viewCustomersPerBranch();
                    break;
                case 5:
                    viewCustomerTransactions();
                    break;
                case 6:
                    addTransacton();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }
    }

    private static void addTransacton() {
        System.out.print("Please provide a branch: ");
        String branchName = scanner.nextLine();
        System.out.print("Please provide customer name: ");
        String custName = scanner.nextLine();
        System.out.print("Please provide amount of transaction: ");
        Double amount = scanner.nextDouble();
        DeutscheBank.addTransactionToCustomer(branchName,custName,amount);
    }

    private static void viewCustomerTransactions() {
        System.out.print("Enter branch: ");
        String branchName = scanner.nextLine();
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        DeutscheBank.viewCustomerTransactions(branchName, customerName);

    }

    private static void viewCustomersPerBranch() {
        System.out.print("Please provide name of branch: ");
        String branchName = scanner.nextLine();
        DeutscheBank.listAllCustomers(branchName);
    }

    private static void addCustomer() {
        System.out.print("Please provide a branch: ");
        String branchName = scanner.nextLine();
        System.out.print("Please provide customer name: ");
        String custName = scanner.nextLine();
        System.out.print("Please provide amount of initial transaction: ");
        Double amount = scanner.nextDouble();
        Customer customer = new Customer(custName, amount);
        DeutscheBank.addCustomerToBranch(branchName, customer);
    }

    private static void listAllBranches() {
        DeutscheBank.listAllBranches();
    }

    private static void addBranch() {
        System.out.print("Please provide a name for your branch: ");
        String branchName = scanner.nextLine();
        Branch branch = new Branch(branchName.toLowerCase());
        DeutscheBank.addBranch(branch);
        System.out.println("Branch " + branch.getName() + " added");
    }

    private static void printMenu() {
        System.out.println("1 -> print options menu \n" +
                           "2 -> add a new branch \n" +
                            "3 -> list all branches \n" +
                            "4 -> add customer to branch \n" +
                            "5 -> List all customers from branch \n" +
                            "6 -> View all customer transactions \n" +
                            "7 -> Add transaction for customer \n" +
                            "8 -> quit \n");
    }
}
