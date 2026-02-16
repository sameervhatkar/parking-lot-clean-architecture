package entity;
import enum_.VehicleType;

public class Slot {
    private final int slotId;
    private VehicleType allowedType;
    private boolean isFree = true;
    private Vehicle vehicle;

    public Slot(int slotId, VehicleType allowedType) {
        this.slotId = slotId;
        this.allowedType = allowedType;
    }

    public boolean isFree() {
        return isFree;
    }

    public int getSlotId() {
        return slotId;
    }

    public boolean park(Vehicle vehicle) {
        if(!isFree)
            return false;
        if(vehicle.getType() != allowedType)
            return false;
        this.isFree = false;
        this.vehicle = vehicle;
        return true;
    }

    public void unpark() {
        if(isFree)
            throw new IllegalStateException("Slot is already Free");

        vehicle = null;
        isFree = true;
    }
}
