package edu.connector;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Created by Mike on 01.05.2017.
 */
public class DBConnector {

    private Connection connection = null;

    public DBConnector(){
        try {
            Properties properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/resources/dbConnection.properties");
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

    public Connection getConnection() {
        return connection;
    }

    public void disconnect() throws SQLException {
        connection.close();
    }

}
