package edu.dao.users;


import edu.connector.DBConnector;
import edu.models.users.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * UserDAO represents major functions to work with User object and database.
 * Created by Mike on 02.05.2017.
 */

public class UserDAO {

    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;
    private String sql;

    /**
     * Create new user and put it to database.
     * @param user is an input User object.
     * @throws SQLException
     */
    public void createUser(User user) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "INSERT INTO users (user_id, user_name, password) VALUES (?,?,?)";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, user.getUserID());
        pStatement.setString(2, user.getUserName());
        pStatement.setString(3, user.getPassword());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Update existing user and put it to database.
     * @param user is an input User object.
     * @throws SQLException
     */
    public void updateUser(User user) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "UPDATE users SET user_name = ?, password = ? WHERE user_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setString(1, user.getUserName());
        pStatement.setString(2, user.getPassword());
        pStatement.setObject(3, user.getUserID());
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Delete existing user from database.
     * @param id is an user id.
     * @throws SQLException
     */
    public void deleteUser(UUID id) throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "DELETE FROM users WHERE user_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        pStatement.executeUpdate();

        pStatement.close();
        connection.close();
        connector.disconnect();
    }

    /**
     * Get user by id.
     * @param id is an user id.
     * @return User object.
     * @throws SQLException
     */
    public User getUserById(UUID id) throws SQLException {

        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM users WHERE user_id = ?";

        pStatement = connection.prepareStatement(sql);
        pStatement.setObject(1, id);
        resultSet = pStatement.executeQuery();

        User user = new User();
        while (resultSet.next()){
            user.setUserID(UUID.fromString(resultSet.getString("user_id")));
            user.setUserName(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return user;
    }

    /**
     * Get all users.
     * @return user list.
     * @throws SQLException
     */
    public List<User> getAllUsers() throws SQLException {
        DBConnector connector = new DBConnector();
        connection = connector.getConnection();
        sql = "SELECT * FROM users";

        pStatement = connection.prepareStatement(sql);
        resultSet = pStatement.executeQuery();

        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            User user = new User();
            user.setUserID(UUID.fromString(resultSet.getString("user_id")));
            user.setUserName(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            users.add(user);
        }

        resultSet.close();
        pStatement.close();
        connection.close();
        connector.disconnect();

        return users;
    }

}
