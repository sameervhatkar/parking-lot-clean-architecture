package strategy;

import entity.Ticket;

import java.time.LocalDateTime;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket, LocalDateTime exitTime);
}
