package com.revature;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Singleton Design Pattern
// -> a design through which you only ever create ONE SINGLE instance
public class ConnectionFactory {

    private static Connection instance;

    // "jdbc:<dialect>://<host name>:<port>/<database name>?currentSchema=<schema name>"
    private static final String url =
            "javareact.cjurl0s0kcsf.us-east-2.rds.amazonaws.com";
    private static final String username = "postgres";
    private static final String password = "Rocknwa25";


    // this method creates a single instance if needed otherwise, returns the existing one.
    public static Connection getConnection() throws SQLException {

        if(instance == null || instance.isClosed()){
            // url, username, password ->
//            Class.forName("org.postgresql.Driver"); <- this may be necessary to solve no suitable driver
            instance = DriverManager.getConnection(url, username, password);
        }

        return instance;
    }

    private ConnectionFactory(){}
}
