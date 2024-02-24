package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClientService {

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:C:/Users/these/Desktop/db/workers", "sa", "");

            ClientService clientService = new ClientService(connection);

                //CREATE
//            long clientId = clientService.create("Vova Semenov");
//            System.out.println("Client ID: " + clientId);

                //READ
//            String clientName = clientService.getById(6);
//            System.out.println("Client name: " + clientName);

                //UPDATE
//            clientService.setName(6, "Semenov Vova");
//            String clientName = clientService.getById(6);
//            System.out.println("Client name: " + clientName);

                //DELETE
            clientService.deleteById(6);
            List<Client> clients = clientService.listAll();
            System.out.println("All clients: " + clients);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Connection connection;

    public ClientService(Connection connection) {
        this.connection = connection;
    }

    public long create(String name) throws SQLException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім або null");
        }

        String insertQuery = "INSERT INTO client (NAME) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, name);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Створення клієнта не вдалося, жоден рядок не було змінений");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Створення клієнта не вдалося, ID не отримано");
                }
            }
        }
    }

    public String getById(long id) throws SQLException {
        String selectQuery = "SELECT NAME FROM client WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("NAME");
                }
            }
        }
        return null;
    }

    public void setName(long id, String name) throws SQLException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Ім'я не може бути порожнім або null");
        }

        String updateQuery = "UPDATE client SET NAME = ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, name);
            statement.setLong(2, id);
            statement.executeUpdate();
        }
    }

    public void deleteById(long id) throws SQLException {
        String deleteQuery = "DELETE FROM client WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    public List<Client> listAll() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String selectQuery = "SELECT * FROM client";
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    long id = resultSet.getLong("ID");
                    String name = resultSet.getString("NAME");
                    clients.add(new Client(id, name));
                }
            }
        }
        return clients;
    }

    public class Client {
        private long id;
        private String name;

        public Client(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Client ID: " + id + ", Name: " + name;
        }
    }
}
