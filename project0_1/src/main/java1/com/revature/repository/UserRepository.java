package com.revature.repository;

import com.revature.model.User;
import com.revature.util.ConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

/**
    UserRepository is the starting point of our persistence layer.

    CRUD Operations are those that allow the modification or persistence of data in some

                                DML -> Data Manipulation Language
    C - Create                  insert
    R - Read                    select
    U - Up.date                  update
    D - De.lete                  delete
 */
public class UserRepository implements DAO<User>{
    private static final Logger logger = LogManager.getLogger(UserRepository.class);

    @Override
    public void create(User user){
        // here we write our SQL to create a user
        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "insert into users(username, password) values (?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());

            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public User getByUsername(String username){
        User user = null;

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from users where username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            // this
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
        return user;
    }

    // select * from users where id = ?
    @Override
    public User getById(int id){

        User user = null;
        String sql = "select * from users where id = ?";
        Connection connection;

        try{
            connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    // select * from users
    @Override
    public List<User> getAll(){
        return null;
    }

    @Override
    public void update(User user){

    }

    // delete from users where id = ?
    @Override
    public void deleteById(int id){

    }
}
