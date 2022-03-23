package com.revanture.chaslsBank;

import java.util.Scanner;

public class Accounts {
    BankRepository update = new BankRepository();
    Scanner scanner = new Scanner(System.in);

    public void accountProcess() {
boolean inAccount = true;
        while (inAccount) {

            // giving users banking options to update their bank account
            System.out.println("1 balance: ");
            System.out.println("2 deposit: ");
            System.out.println("3 withdraw: ");
            System.out.println("0 to exit app: ");
            int menuOptions = scanner.nextInt(); // created a user input for
            switch (menuOptions) {
                case 1:
                    System.out.println("Balance is: $");
                    update.getBalance();// pulls balances from database
                    System.out.println(update.getBalance());
                    break;

                case 2:
                    System.out.println("How much would you like to deposit? $");// create deposit based on user input
                    double deposit = scanner.nextDouble();
                    update.getDeposit(deposit);// pulls from SQL server
                    System.out.println(update.getBalance());// prints out the updated balance
                    break;
                case 3:
                    System.out.println("How much would you like to withdraw: $");
                    double withdraw = scanner.nextDouble();
                    update.getWithdraw(withdraw);// pulls from SQL server
                    System.out.println(update.getBalance());// prints out the updated balance
                    break;

                case 0:
                    inAccount = false;
                    break;
            }
        }
    }

}
