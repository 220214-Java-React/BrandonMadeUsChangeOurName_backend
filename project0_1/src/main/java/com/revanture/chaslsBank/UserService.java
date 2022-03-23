package com.revanture.chaslsBank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Scanner;

public class UserService {
    private static User currentUser; // to set the current user after they log on
    private final Logger logger;
    private final Scanner scanner;
    private final MessageDigest messageDigest;
    private final UserRepository userRepository;

    public UserService() throws NoSuchAlgorithmException {
        this.logger = LogManager.getLogger(UserService.class);
        this.scanner = ScannerFactory.getScanner();
        this.messageDigest = MessageDigest.getInstance("SHA-512");
        this.userRepository = new UserRepository();
        currentUser = null;
    }

    public void register() {
        System.out.println("\n-- User Registration --"); // register a new user and store it into users table
        userRepository.create(buildUser());
    }

    public User login() {
        System.out.println("\n-- User Login --"); // login to see if username is valid
        return validation();
    }

    private User validate() {
        User user = new User(getUsername(), getPassword(), getBalance());
        return isValid(user) ? user : null;
    }

    private User validation() {
        User user = new User(getUsername(), getPassword()); // check user name and pass in the users table
        return isValid(user) ? user : null;
    }

    private boolean isValid(User user) {

        User dbUser = userRepository.getByUsername(user.getUsername()); // creates a new user type against the userRep

        if (dbUser != null) {
            if (dbUser.getPassword().equals(user.getPassword())) { // check to see if null if not the sets currentuser to dbuser
                currentUser = dbUser;
                System.out.println("Successs. Welcome! " + currentUser.getUsername()); // allows login
                return true;
            }
        }

        System.out.println("Invalid credentials.");
        return false;
    }

    private User buildUser() {
        User user = new User(getUsername(), getPassword(), getBalance()); // builds a new username and pw for users table
        return !exists(user) ? user : buildUser();
    }

    private double getBalance() { // sets orginal balance to 0;
        double balance = 0.00;
        return balance;
    }

    private String getUsername() { // creates username
        String username = "";
        boolean valid = false;

        while (!valid) {
            System.out.print("Username: ");
            username = scanner.nextLine();

            //TODO: Username validation
            if (username.length() > 4) {
                valid = true;
            } else {
                System.out.println("Username must be longer than 4 characters.");
            }
        }
        return username.toLowerCase(Locale.ROOT);
    }

    private String getPassword() {// creates password
        String password = "";
        boolean valid = false;

        while (!valid) {
            System.out.print("Password: ");
            password = scanner.nextLine();

            //TODO: Password validation
            if (password.length() > 4) {
                valid = true;
            } else {
                System.out.println("Password must be longer than 4 characters.");
            }
        }
        return encryptPassword(password);
    }

    private boolean exists(User user) {
        // need to check if the username exists
        if (userRepository.getByUsername(user.getUsername()) == null) { // encrypts password
            return false;
        } else {
            System.out.println("Username already exists.");
            return true;
        }


    }

    private String encryptPassword(String password) {
        return new String(messageDigest.digest(password.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }
}
