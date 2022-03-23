package com.revature;

import com.revature.users.Users;
import com.revature.services.Accounts;
import com.revature.services.BankProcesses;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;

import java.util.Scanner;

public class Application {
    private static User currentUser;
    private static UserService userService;
    private static Logger logger;

    public void runApplication() {
        BankProcesses active = new BankProcesses();

        Users currentUser = new Users();


        boolean systemLogedIn = true;
        Scanner scanner = new Scanner(System.in);

        while (systemLogedIn == true) {

            System.out.println("Welcome to Chasls Banks,\nthe best new bank in all of Revature!");
            System.out.println("How can we help you today?");
            System.out.println("Press 1: Sign Up!");
            System.out.println("Press 2: Log In!");
            System.out.println("Press 3: Exit App!");
            int userInput = scanner.nextInt();
            Users user1 = new Users();
            switch (userInput) {
                case 1:
                    userService.register();

                    break;

                case 2:
                    Accounts accountProcess = new Accounts();
                    accountProcess.accountProcess();
                    System.out.println("something happening");


                    break;
                case 3:


            }

        }
    }

}