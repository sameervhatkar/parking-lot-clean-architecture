package entity;

import java.time.LocalDateTime;
import enum_.VehicleType;

public class Ticket {
    private final int ticketId;
    private final int floorNumber;
    private final int slotNumber;
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private final LocalDateTime entryTime;

    public Ticket(int ticketId, int slotNumber, String vehicleNumber, VehicleType vehicleType, LocalDateTime entryTime, int floorNumber) {
        this.ticketId = ticketId;
        this.slotNumber = slotNumber;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.entryTime = entryTime;
        this.floorNumber = floorNumber;
    }

    public int getTicketId() {
        return ticketId;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    @Override
    public String toString() {
        return "Entity.Ticket: " +
                "\nticketId=" + ticketId +
                "\nslotNumber=" + slotNumber +
                "\nvehicleNumber='" + vehicleNumber + '\'' +
                "\nvehicleType=" + vehicleType +
                "\nentryTime=" + entryTime;
    }
}
