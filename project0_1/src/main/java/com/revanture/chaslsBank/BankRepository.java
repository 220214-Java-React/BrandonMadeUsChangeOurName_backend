package com.revanture.chaslsBank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class BankRepository {
    private static final Logger logger = LogManager.getLogger(BankRepository.class);
    private double balance = 0.00;

    Application app = new Application();

    public void updateBalance() {
        try (Connection connection = ConnectionFactory.getConnection()) {// connecting to my db server
            String sql = "update users set balance = ? where username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setDouble(1, balance);
            stmt.setString(2, app.currentuser());

            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
    }

    public double getBalance() { // check the current balance via sql server

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select distinct balance from users where username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, app.currentuser());

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {

                balance = resultSet.getDouble("balance");
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
        return balance;
    }

    public double getWithdraw(double withdraw) {
        getBalance();// calls the balance from the SQL server for current user
        if (withdraw <= 0) {
            try {
                System.out.println("Cant withdraw a negative balance. balance: $" + balance);
            } catch (ExceptionInInitializerError E) {
                System.out.println("withdraw failed");
            }
        }
        if (balance >= withdraw) { // check to make sure balance can't go negative
            balance -= withdraw;// subjects the users withdraw from balance
        } else {
            try {
                System.out.println("Insufficient funds balance: $" + balance);
            } catch (ExceptionInInitializerError E) {
                System.out.println("withdraw failed");
            }
        }
        updateBalance(); // updates the users balance on the users table
        return balance;
    }

    public double getDeposit(double deposit) { // creates a deposit for current user
        getBalance();// calls the balance from the SQL server for current user

        balance += deposit; //adds the deposit amout to the balance
        updateBalance(); // updates the user balance on the users table
        return balance;
    }
}