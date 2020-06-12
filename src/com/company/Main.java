package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankAccount myBankAccount = new BankAccount("Denisa", 123456789);
        myBankAccount.showMenu();

    }
}

class BankAccount {

    private String customerName;
    private int accountNumber;
    private double balance;
    private double previousTransaction;

    public BankAccount(String customerName, int accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        if(amount > 0 && amount <= 10000) {
            balance += amount;
            previousTransaction = amount;
        } else {
            System.out.println("Invalid amount. Deposit must be higher than 1 and below 10.000");
        }
    }

    public void withdraw (double amount) {
        if(amount <= balance) {
            balance = balance - amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void getPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if(previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    public void showMenu() {

        char option;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your bank account number is " + accountNumber);
        System.out.println("\n");
        System.out.println("A. Check balance\n" +
                "B. Deposit\n" +
                "C. Withdraw\n" +
                "D. Previous transaction\n" +
                "E. Exit");

        do {
            System.out.println("===========================================================");
            System.out.println("Enter an option");
            System.out.println("============================================================");

            option = scanner.next().charAt(0);
            option = Character.toUpperCase(option);
            if(Character.toString(option).length() > 1) {
                System.out.println("Invalid option. Please enter a valid option!");
            }

            System.out.println("\n");

            switch(option) {
                case 'A':
                    System.out.println("--------------------------------------------------");
                    System.out.println("The balance is: " + balance);
                    System.out.println("--------------------------------------------------\n");
                    break;

                case 'B':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Enter an amount to deposit:");
                    while(!scanner.hasNextDouble()) {
                        System.out.println("Invalid input\n");
                        scanner.next();
                    }
                    double amount = scanner.nextDouble();
                    deposit(amount);
                    System.out.println("--------------------------------------------------\n");
                    break;

                case 'C':
                    System.out.println("--------------------------------------------------");
                    System.out.println("Enter an amount to withdraw:");
                    while(!scanner.hasNextDouble()) {
                        System.out.println("Invalid input\n");
                        scanner.next();
                    }
                    double amount2 = scanner.nextDouble();
                    withdraw(amount2);
                    System.out.println("--------------------------------------------------\n");
                    break;

                case 'D':
                    System.out.println("--------------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("--------------------------------------------------\n");
                    break;

                case 'E':
                    System.out.println("*****************************************************");
                    break;

                default:
                    System.out.println("Invalid option! Please enter again");
                    break;

            }
        } while(option != 'E');

        System.out.println("Thank you for using our services. Goodbye!");

    }
}
