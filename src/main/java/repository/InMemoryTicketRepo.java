package repository;

import entity.Ticket;

import java.util.HashMap;
import java.util.Map;

public class InMemoryTicketRepo implements TicketRepo {

    private final Map<Integer, Ticket> store = new HashMap<>();
    @Override
    public void save(Ticket ticket) {
        store.put(ticket.getTicketId(), ticket);
    }

    @Override
    public Ticket findById(int ticketId) {
        return store.get(ticketId);
    }

    @Override
    public void deleteById(int ticketId) {
        store.remove(ticketId);
    }
}
