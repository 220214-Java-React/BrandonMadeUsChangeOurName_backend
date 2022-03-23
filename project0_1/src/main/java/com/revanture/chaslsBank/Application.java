package com.revanture.chaslsBank;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Application {
    private static User currentUser;
    private static UserService userService;
    private static Logger logger;

    public String currentuser() {
        return currentUser.username;
    }

    public void runApplication() {
        configure();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Welcome to Chasls Banks,\nthe best new bank in all of Revature!");// menu option to crate or login
            System.out.println("How can we help you today?");
            System.out.println("Press 1: Sign Up!");
            System.out.println("Press 2: Log In!");
            System.out.println("Press 3: Exit App!");
            int userInput = scanner.nextInt();
            switch (userInput) {

                case 1:
                    userService.register();// create username and pw and stores it to SQL db
                    break;
                case 2:
                    currentUser = userService.login(); // logs into account based on SQL db
                    if(currentUser != null) {
                        Accounts accountProcess = new Accounts(); //
                        accountProcess.accountProcess();// runs the second table of banking options
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    try {
                        System.out.println("Invalded input: " + userInput );
                    } catch (ExceptionInInitializerError E) {
                        System.out.println("resetApp");
                    }
                    break;


            }
        }
    }

    private static void configure() {
        currentUser = null;
        logger = LogManager.getLogger(Application.class);

        try {
            userService = new UserService();
        } catch (NoSuchAlgorithmException e) {
            logger.warn(e.getMessage(), e);
        }

    }
}