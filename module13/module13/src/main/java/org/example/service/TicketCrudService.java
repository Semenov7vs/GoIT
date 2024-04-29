package org.example.service;

import org.example.dao.TicketDao;
import org.example.model.Ticket;

import java.util.List;

public class TicketCrudService {
    private final TicketDao ticketDao = new TicketDao();

    public void saveTicket(Ticket ticket) {

        try {
            if (ticket.getClient() == null || ticket.getFromPlanet() == null || ticket.getToPlanet() == null) {
                throw new IllegalArgumentException("Ticket must have a valid.");
            }
            ticketDao.save(ticket);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        public Ticket findTicketById (Long id){
            return ticketDao.findById(id);
        }

        public void updateTicket (Ticket ticket){
            ticketDao.update(ticket);
        }

        public void deleteTicket (Ticket ticket){
            ticketDao.delete(ticket);
        }

    }