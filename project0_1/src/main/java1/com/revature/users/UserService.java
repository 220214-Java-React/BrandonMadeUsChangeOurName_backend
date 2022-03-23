package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;
import com.revature.util.ScannerFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UserService {
    private static User currentUser;
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

    public void register(){
        System.out.println("\n-- User Registration --");
        userRepository.create(buildUser());
    }

    public User login(){
        System.out.println("\n-- User Login --");
        return validate();
    }

    public static User getCurrentUser(){
        return currentUser;
    }

    private User validate(){
        User user = new User(getUsername(), getPassword());
        return isValid(user) ? user : null;
    }

    private boolean isValid(User user){

        User dbUser = userRepository.getByUsername(user.getUsername());

        if(dbUser != null){
            if(dbUser.getPassword().equals(user.getPassword())) {
                currentUser = dbUser;
                return true;
            }
        }

        System.out.println("Invalid credentials.");
        return false;
    }

    private User buildUser(){
        User user = new User(getUsername(), getPassword());
        return !exists(user) ? user : buildUser();
    }

    private String getUsername(){
        String username = "";
        boolean valid = false;

        while(!valid){
            System.out.print("Username: ");
            username = scanner.nextLine();

            //TODO: Username validation
            if(username.length() > 4){
                valid = true;
            } else {
                System.out.println("Username must be longer than 4 characters.");
            }
        }
        return username;
    }

    private String getPassword(){
        String password = "";
        boolean valid = false;

        while(!valid){
            System.out.print("Password: ");
            password = scanner.nextLine();

            //TODO: Password validation
            if(password.length() > 4){
                valid = true;
            } else{
                System.out.println("Password must be longer than 4 characters.");
            }
        }
        return encryptPassword(password);
    }

    private boolean exists(User user){
        // need to check if the username exists
        if (userRepository.getByUsername(user.getUsername()) == null){
            return false;
        } else{
            System.out.println("Username already exists.");
            return true;
        }

        // if method returns null -> the user doesnt exist !(true)

//        return !(userRepository.getUserByUsername(user.getUsername()) == null);

        // if it does, let them know and return true

        // if it doesn't return false
    }
    private String encryptPassword(String password){
        return new String(messageDigest.digest(password.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }
}
