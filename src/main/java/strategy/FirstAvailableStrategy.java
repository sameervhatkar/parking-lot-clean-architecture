package strategy;
import entity.*;

public class FirstAvailableStrategy implements ParkingStrategy {
    @Override
    public Floor[] orderFloors(Floor[] floors) {
        return floors;
    }
}
