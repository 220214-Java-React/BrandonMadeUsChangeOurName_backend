package com.revature.services;

import java.util.Scanner;

public class Accounts {
    BankProcesses active = new BankProcesses();
    Scanner scanner = new Scanner(System.in);

    public void accountProcess() {

        while (true) {


            System.out.println("1 balance: ");
            System.out.println("2 deposit: ");
            System.out.println("3 withdraw: ");
            System.out.println("0 to exit app: ");
            int menuOptions = scanner.nextInt();
            switch (menuOptions) {
                case 1:

                    System.out.println("Balance is: $");

                    active.checkBalance(active.balance);
                    System.out.println(active.balance);

                    break;

                case 2:
                    System.out.println("How much would you like to deposit? $");
                    double deposit = scanner.nextDouble();
                    active.depositMoney(deposit);
                    System.out.println(active.balance);
                    break;
                case 3:

                    System.out.println("How much would you like to withdraw: $");
                    double withdraw = scanner.nextDouble();
                    active.withdrawMoney(withdraw);
                    System.out.println(active.balance);
                    break;

                case 0:

                    System.exit(0);

                    break;


            }
        }
    }

}
