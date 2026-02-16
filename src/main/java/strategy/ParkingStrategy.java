package strategy;

import entity.Floor;
import entity.Slot;
import entity.Vehicle;

public interface ParkingStrategy {
    Floor[] orderFloors(Floor[] floors);
}
