package org.example.service;

import org.example.db.DbConfig;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.service.hibernate.HibernateUtil;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;


public class HibernateCrudUsageExample {
    public static void main(String[] args) {
        DbConfig dbConfig = new DbConfig();
        Flyway flyway = Flyway.configure()
                .dataSource(dbConfig.getDbUrl(), dbConfig.getUsername(), dbConfig.getPassword())
                .load();
        flyway.migrate();


        //CREATE
//        ClientCrudService clientCrudService = new ClientCrudService();
//        Client client = new Client();
//        client.setName("Volodymyr Semenov");
//        clientCrudService.saveClient(client);


        //READ
//        Long idClientForRead = 11L;
//        ClientCrudService clientCrudService = new ClientCrudService();
//        Client clientToRead = clientCrudService.findClientById(idClientForRead);
//
//        if (clientToRead != null) {
//            System.out.println("ID: " + clientToRead.getId());
//            System.out.println("Name: " + clientToRead.getName());
//        } else {
//            System.out.println("Client not found.");
//        }

        //UPDATE
//        Long idClientForUpdate = 11L;
//        ClientCrudService clientCrudService = new ClientCrudService();
//        Client clientToUpdate = clientCrudService.findClientById(idClientForUpdate);
//
//        if (clientToUpdate != null) {
//            clientToUpdate.setName("Semenov Volodymyr");
//            clientCrudService.updateClient(clientToUpdate);
//            System.out.println("Client is UPDATE.");
//        } else {
//            System.out.println("Client IS NOT UPDATE.");
//        }

        //DELETE
//        Long idClientForDelete = 11L;
//        ClientCrudService clientCrudService = new ClientCrudService();
//        Client clientToDelete = clientCrudService.findClientById(idClientForDelete);
//
//        if (clientToDelete != null) {
//            clientCrudService.deleteClient(clientToDelete);
//            System.out.println("Client is DELETE.");
//        } else {
//            System.out.println("Client IS NOT DELETE.");
//        }


        //CREATE FOR PLANET
//        PlanetCrudService planetCrudService = new PlanetCrudService();
//        Planet planet = new Planet();
//        planet.setName("Mercury");
//        planet.setId("MER");
//        planetCrudService.savePlanet(planet);

        //READ FOR PLANET
//        String idPlanetForRead = "MER";
//        PlanetCrudService planetCrudService = new PlanetCrudService();
//        Planet planetToRead = planetCrudService.findPlanetById(idPlanetForRead);
//
//        if (planetToRead != null) {
//            System.out.println("ID: " + planetToRead.getId());
//            System.out.println("Name: " + planetToRead.getName());
//        } else {
//            System.out.println("Planet not found.");
//        }

        //UPDATE FOR PLANET
//        String idPlanetForUpdate = "MER";
//        PlanetCrudService planetCrudService = new PlanetCrudService();
//        Planet planetToUpdate = planetCrudService.findPlanetById(idPlanetForUpdate);
//
//        if (planetToUpdate != null) {
//            planetToUpdate.setName("Mars");
//            planetCrudService.updatePlanet(planetToUpdate);
//            System.out.println("Planet is UPDATE.");
//        } else {
//            System.out.println("Planet IS NOT UPDATE.");
//        }

        //DELETE FOR PLANET
//        String idPlanetForDelete = "MER";
//        PlanetCrudService planetCrudService = new PlanetCrudService();
//        Planet planetToDelete = planetCrudService.findPlanetById(idPlanetForDelete);
//
//        if (planetToDelete != null) {
//            planetCrudService.deletePlanet(planetToDelete);
//            System.out.println("Planet is DELETE.");
//        } else {
//            System.out.println("Planet IS NOT DELETE.");
//        }


        HibernateUtil.getInstance().close();
    }
}