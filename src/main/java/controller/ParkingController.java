package controller;

import entity.Ticket;
import entity.Vehicle;
import service.ParkingService;
import enum_.VehicleType;

public class ParkingController {
//    private final ParkingService parkingService;
//
//    public ParkingController(ParkingService parkingService) {
//        this.parkingService = parkingService;
//    }
//
//    public void park(String vehicleNumber, VehicleType type) {
//        Vehicle vehicle = new Vehicle(vehicleNumber, type);
//        Ticket ticket = parkingService.park(vehicle);
//
//        if(ticket == null)
//            System.out.println("Sorry, you are not able to park because no slot available.");
//
//        else
//            System.out.println("Vehicle parked successfully, Ticket ID: " + ticket.getTicketId());
//    }
//
//    public void unpark(int ticketId) {
//        boolean success = parkingService.unPark(ticketId);
//
//        if(success)
//            System.out.println("Vehicle unparked successfully, visit again");
//        else
//            System.out.println("Invalid Ticket ID");
//    }
}
