package repository;

import entity.Ticket;

public interface TicketRepo {
    void save(Ticket ticket);
    Ticket findById(int ticketId);
    void deleteById(int ticketId);
}
