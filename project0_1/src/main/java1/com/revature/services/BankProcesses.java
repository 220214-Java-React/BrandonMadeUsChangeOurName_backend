package com.revature.services;

import static java.lang.System.*;

public class BankProcesses {

    protected double balance;
    private double withdraw;
    private double deposit;


    //shows the balance of the the users account
    public double checkBalance(double balance) {
        this.balance = balance;
        return balance;
    }
        // this will withdraw money from the users account
    public double withdrawMoney(double withdraw) {
        this.withdraw = withdraw;

        if (balance >= withdraw) { // check to make sure the withdraw amount is less than balance
            balance -= withdraw;  // take the withdraw out of the balance
            return balance;
        } else {
            try{
               System.out.println( "Insufficient funds balance: $" + balance);
            }
            catch(Exception e){
                System.out.println("withdraw failed");

            }; //doesnt allow them take if the balance is to little
        }
        return balance;
    }

    public double depositMoney(double deposit) {

        this.deposit = deposit;
        balance += deposit;
        return balance;
    }

}
