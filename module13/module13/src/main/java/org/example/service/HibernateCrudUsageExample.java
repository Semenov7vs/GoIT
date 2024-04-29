package org.example.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.example.db.DbConfig;
import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.hibernate.HibernateUtil;
import org.flywaydb.core.Flyway;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;


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

        //CREATE FOR TICKET
//        TicketCrudService ticketCrudService = new TicketCrudService();
//
//        Long idClientForTicket = 1L;
//        ClientCrudService clientCrudService = new ClientCrudService();
//        Client clientForTicket = clientCrudService.findClientById(idClientForTicket);
//
//        if (clientForTicket == null) {
//            System.out.println("Client with ID " + idClientForTicket + " does not find.");
//            return;
//        }
//
//        String idPlanetForTicketFrom = "";
//        PlanetCrudService planetCrudServiceFrom = new PlanetCrudService();
//        Planet fromPlanet = planetCrudServiceFrom.findPlanetById(idPlanetForTicketFrom);
//        if (fromPlanet == null) {
//            System.out.println("Planet with ID " + idPlanetForTicketFrom + " does not find.");
//            return;
//        }
//        String idPlanetForTicketTo = "URA";
//        PlanetCrudService planetCrudServiceTo = new PlanetCrudService();
//
//        Planet toPlanet = planetCrudServiceTo.findPlanetById(idPlanetForTicketTo);
//
//        if (toPlanet == null) {
//            System.out.println("Planet with ID " + idPlanetForTicketTo + " does not find.");
//            return;
//        }
//        Ticket ticket = new Ticket(clientForTicket, fromPlanet, toPlanet);
//        ticketCrudService.saveTicket(ticket);

        // READ FOR TICKET
//        TicketCrudService ticketCrudService = new TicketCrudService();
//
//        Long ticketId = 1L;
//        Ticket ticket = ticketCrudService.findTicketById(ticketId);
//
//        if (ticket != null) {
//            System.out.println("Ticket found:");
//            System.out.println(ticket);
//        } else {
//            System.out.println("Ticket with ID " + ticketId + " not found.");
//        }

        // UPDATE FOR TICKET
//        TicketCrudService ticketCrudService = new TicketCrudService();
//
//        Long ticketIdToUpdate = 1L;
//        Ticket ticketToUpdate = ticketCrudService.findTicketById(ticketIdToUpdate);
//
//        if (ticketToUpdate != null) {
//            ticketToUpdate.setCreatedAt(LocalDateTime.now());
//            ticketCrudService.updateTicket(ticketToUpdate);
//
//            System.out.println("Ticket with ID " + ticketIdToUpdate + " updated.");
//        } else {
//            System.out.println("Ticket with ID " + ticketIdToUpdate + " not found.");
//        }

        // DELETE FOR TICKET
//        TicketCrudService ticketCrudService = new TicketCrudService();
//
//        Long ticketIdToDelete = 1L;
//        Ticket ticketToDelete = ticketCrudService.findTicketById(ticketIdToDelete);
//
//        if (ticketToDelete != null) {
//            ticketCrudService.deleteTicket(ticketToDelete);
//
//            System.out.println("Ticket with ID " + ticketIdToDelete + " deleted.");
//        } else {
//            System.out.println("Ticket with ID " + ticketIdToDelete + " not found.");
//        }
//

        HibernateUtil.getInstance().close();
    }
}