package entity;

import enum_.ParkingCategory;
import enum_.VehicleType;

public class Vehicle {

    private final String number;
    private final VehicleType type;
    private final ParkingCategory parkingCategory;

    public Vehicle(String number, VehicleType type, ParkingCategory parkingCategory) {
        this.number = number;
        this.type = type;
        this.parkingCategory = parkingCategory;
    }

    public String getNumber() {
        return number;
    }


    public VehicleType getType() {
        return type;
    }

    public ParkingCategory getParkingCategory() {
        return parkingCategory;
    }
}
