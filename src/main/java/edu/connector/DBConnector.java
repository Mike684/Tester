package edu.connector;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * DBConnector represent connectivity between app and database.
 * Created by Mike on 01.05.2017.
 */
public class DBConnector {

    private Connection connection = null;

    /**
     * Create database connection from *.properties file.
     */
    public DBConnector(){
        try {
            Properties properties = new Properties();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream fis = classLoader.getResourceAsStream("dbConnection.properties");
            properties.load(fis);
            fis.close();

            String drivers = properties.getProperty("jdbc.driverClassName");
            String connectionURL = properties.getProperty("jdbc.url");
            String username = properties.getProperty("jdbc.username");
            String password = properties.getProperty("jdbc.password");
            Class.forName(drivers);
            connection = DriverManager.getConnection(connectionURL,username,password);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

    }

    /**
     * Get current connection.
     * @return current connection.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Close connection.
     * @throws SQLException
     */
    public void disconnect() throws SQLException {
        connection.close();
    }

}
