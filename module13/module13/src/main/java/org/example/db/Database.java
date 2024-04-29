package org.example.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
public class Database {

    private static Database instance;
    private static Connection connection;

    private Database() throws SQLException {
        DbConfig dbConfig = new DbConfig();
        connection = DriverManager.getConnection(dbConfig.getDbUrl(),dbConfig.getUsername(),dbConfig.getPassword());
    }

    public static Database getInstance() throws SQLException {
        DbConfig dbConfig = new DbConfig();
        connection = DriverManager.getConnection(dbConfig.getDbUrl());
        if(Objects.isNull(instance)){
            instance = new Database();
        }
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }
    public void close() throws SQLException{
        connection.close();
    }

}