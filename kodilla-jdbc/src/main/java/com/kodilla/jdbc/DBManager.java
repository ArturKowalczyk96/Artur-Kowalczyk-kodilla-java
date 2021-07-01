package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBManager {

    private Connection connection;
    private static DBManager dbManagerInstance;

    private DBManager() throws SQLException {
        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "kodilla_user");
        connectionProperties.put("password", "kodilla_Pass123");
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" + "&useSSL=False&allowPublicKeyRetrieval=true",
                connectionProperties);
    }

    public static DBManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DBManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return connection;
    }
}
