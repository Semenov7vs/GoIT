package org.example.db;

public class DbConfig {
    private static final String DB_URL = "jdbc:h2:C:/Users/these/Desktop/db/space/module13";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    public String getDbUrl() {
        return DB_URL;
    }

    public String getUsername() {
        return USERNAME;
    }

    public String getPassword() {
        return PASSWORD;
    }
}