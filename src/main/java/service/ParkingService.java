package service;

import java.time.LocalDateTime;
import core.ParkingLot;
import repository.*;
import entity.*;
import exception.*;
import strategy.PricingStrategy;

public class ParkingService {
    private final ParkingLot parkingLot;
    private final TicketRepo ticketRepo;
    private final PricingStrategy pricingStrategy;

    private int ticketNumber = 1;

    public ParkingService(ParkingLot parkingLot, TicketRepo ticketRepo, PricingStrategy pricingStrategy) {
        this.parkingLot = parkingLot;
        this.ticketRepo = ticketRepo;
        this.pricingStrategy = pricingStrategy;
    }

    public Ticket park(Vehicle vehicle) {
        int[] location = parkingLot.park(vehicle);
        if(location == null)
            throw new ParkingFullException("Parking lot is full.");

        int floorNumber = location[0];
        int slotNumber = location[1];

        Ticket ticket = new Ticket(ticketNumber++, slotNumber, vehicle.getNumber(), vehicle.getType(), LocalDateTime.now(), floorNumber);
        ticketRepo.save(ticket);
        return ticket;
    }

    public double unPark(int ticketNumber) {
        Ticket ticket = ticketRepo.findById(ticketNumber);

        if(ticket == null)
            throw new InvalidTicketException("Invalid Ticket ID.");
        double amount = pricingStrategy.calculatePrice(ticket, LocalDateTime.now());

        parkingLot.unpark(ticket.getFloorNumber(), ticket.getSlotNumber());
        ticketRepo.deleteById(ticketNumber);
        return amount;
    }
}
