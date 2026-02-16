package entity;

public class Floor {

    private final int floorNumber;
    private final Slot[] slots;
    private final boolean vipOnly;

    public Floor(int floorNumber, Slot[] slots, boolean vipOnly) {
        this.floorNumber = floorNumber;
        this.slots = slots;
        this.vipOnly = vipOnly;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public Slot[] getSlots() {
        return slots;
    }

    public boolean isVipOnly() {
        return vipOnly;
    }
}
