package strategy;
import entity.*;

public class ReverseOrderStrategy implements ParkingStrategy {
    @Override
    public Floor[] orderFloors(Floor[] floors) {
        return new Floor[0];
    }
}
