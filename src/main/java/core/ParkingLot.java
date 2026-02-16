package core;

import entity.Floor;
import entity.Slot;
import entity.Vehicle;
import enum_.ParkingCategory;
import strategy.ParkingStrategy;

public class ParkingLot {
    private final Floor[] floors;
    private final ParkingStrategy strategy;

    public ParkingLot(Floor[] floors, ParkingStrategy strategy) {
        this.floors = floors;
        this.strategy = strategy;
    }

    public int[] park(Vehicle vehicle) {
        Floor[] orderedFloor = strategy.orderFloors(floors);
        for(Floor floor : orderedFloor) {
            if(vehicle.getParkingCategory() == ParkingCategory.VIP && !floor.isVipOnly())
                continue;
            if(vehicle.getParkingCategory() != ParkingCategory.VIP && floor.isVipOnly())
                continue;
            for(Slot slot : floor.getSlots()) {
                if(slot.park(vehicle))
                    return new int[]{floor.getFloorNumber(), slot.getSlotId()};
            }
        }
        return null;
    }

    public void unpark(int floorNumber, int slotNumber) {
        int floorIndex = floorNumber-1;
        int slotIndex = slotNumber - 1;
        if(floorIndex < 0 || floorIndex >= floors.length || slotIndex < 0 || slotIndex >= floors[floorIndex].getSlots().length)
            throw new IllegalStateException("Invalid Floor or Slot Number.");
        floors[floorIndex].getSlots()[slotIndex].unpark();
    }

}
