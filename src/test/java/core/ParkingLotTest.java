package core;

import entity.Floor;
import entity.Slot;
import entity.Vehicle;
import enum_.ParkingCategory;
import enum_.VehicleType;
import org.junit.jupiter.api.Test;
import strategy.FirstAvailableStrategy;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void vipVehicleShouldParkOnlyOnVipFloor() {
        Slot[] normalSlot = {new Slot(1, VehicleType.CAR)};
        Floor floor1 = new Floor(1, normalSlot, false);

        Slot[] vipSlot = {new Slot(1, VehicleType.CAR)};
        Floor floor2 = new Floor(2, vipSlot, true);

        ParkingLot lot = new ParkingLot(new Floor[]{floor1, floor2}, new FirstAvailableStrategy());

        Vehicle vipCar = new Vehicle("KA01", VehicleType.CAR, ParkingCategory.VIP);

        int[] location = lot.park(vipCar);

        assertNotNull(location);
        assertEquals(2, location[0]);
    }

    @Test
    void normalVehicleShouldNotParkOnVipFloor() {
        Slot[] normalSlot = {new Slot(1, VehicleType.CAR)};
        Floor floor1 = new Floor(1, normalSlot, false);

        Slot[] vipSlot = {new Slot(1, VehicleType.CAR)};
        Floor floor2 = new Floor(2, vipSlot, true);

        ParkingLot lot = new ParkingLot(new Floor[]{floor1, floor2}, new FirstAvailableStrategy());

        Vehicle vipCar = new Vehicle("KA01", VehicleType.CAR, ParkingCategory.NORMAL);

        int[] location = lot.park(vipCar);

        assertNotNull(location);
        assertEquals(1, location[0]);

    }

    @Test
    void shouldReturnNullWhenNoSlotAvailable() {
        Slot[] slot = {new Slot(1, VehicleType.CAR)};
        Floor[] floors = {new Floor(1, slot, false)};

        Vehicle vehicle1 = new Vehicle("KA01", VehicleType.CAR, ParkingCategory.NORMAL);
        Vehicle vehicle2 = new Vehicle("KA02", VehicleType.CAR, ParkingCategory.NORMAL);

        ParkingLot lot = new ParkingLot(floors, new FirstAvailableStrategy());

        lot.park(vehicle1);

        int[] location = lot.park(vehicle2);
        assertNull(location);
    }
}
