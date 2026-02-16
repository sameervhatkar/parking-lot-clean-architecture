package strategy;

import entity.Ticket;
import enum_.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class VehicleTypePricingStrategy implements PricingStrategy{

    Map<VehicleType, Double> ratePerHour = new HashMap<>();

    public VehicleTypePricingStrategy(Map<VehicleType, Double> ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    @Override
    public double calculatePrice(Ticket ticket, LocalDateTime exitTime) {
        double minutes = Duration.between(exitTime, ticket.getEntryTime()).toMinutes();

        long hours = (long) Math.ceil(minutes/60.0);

        if(hours <= 0) {
            hours = 1;
        }
        Double rate = ratePerHour.get(ticket.getVehicleType());

        if(rate == null) {
            throw new IllegalStateException("Rate is not configured for this vehivle type.");
        }

        return rate * hours;
    }
}
