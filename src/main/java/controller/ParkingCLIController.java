package controller;

import entity.Ticket;
import entity.Vehicle;
import enum_.ParkingCategory;
import enum_.VehicleType;
import service.ParkingService;
import exception.*;

import java.util.Scanner;

public class ParkingCLIController {
    private final ParkingService parkingService;
    private final Scanner sc = new Scanner(System.in);

    public ParkingCLIController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public void start() {
        boolean running = true;
        while(running) {
            showMenu();
            int choice = nextInt();
            switch (choice) {
                case 1:
                    handlePark();
                    break;
                case 2:
                    handleunpark();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting Parking lot System.");
                    break;
                default:
                    System.out.println("Invalid option. Try again");
            }
        }
    }

    private void showMenu() {
        System.out.println("==== Parking Lot Menu ====");
        System.out.println("1. Park Vehicle");
        System.out.println("2. Unpark Vehicle");
        System.out.println("3. Exit");
        System.out.println("Choose an option: ");
    }

    private void handlePark() {
        System.out.println("Please enter Vehicle number: ");
        String vehicleNumber = sc.next();

        System.out.println("Enter Vehicle Type(CAR / BIKE");
        String vehicleType = sc.next();

        System.out.println("Is the Vehicle falls under VIP or Normal: ");
        String parkCategory = sc.next();

        VehicleType type;
        try {
            type = VehicleType.valueOf(vehicleType.toUpperCase());
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid Vehicle Type.");
            return;
        }

        ParkingCategory parkingCategory;
        try {
            parkingCategory = ParkingCategory.valueOf(parkCategory.toUpperCase());
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid Parking Type.");
            return;
        }

        Vehicle vehicle = new Vehicle(vehicleNumber, type, parkingCategory);
        try {
            Ticket ticket = parkingService.park(vehicle);
            System.out.println("Vehicle parked successfully, Ticket ID: " + ticket.getTicketId());
        }
        catch (ParkingFullException e) {
            System.out.println(e.getMessage());
        }



    }

    private void handleunpark() {
        System.out.println("Enter Ticket ID: ");
        int ticketId = sc.nextInt();

        try {
            double amount = parkingService.unPark(ticketId);
            System.out.println("Total bill: ₹" + amount);
            System.out.println("Vehicle unpark successfully.");
        }
        catch(InvalidTicketException e) {
            System.out.println(e.getMessage());
        }


    }

    private int nextInt() {
        while(!sc.hasNextInt()) {
            System.out.println("Please enter number. ");
            sc.next();
        }

        return sc.nextInt();
    }
}
