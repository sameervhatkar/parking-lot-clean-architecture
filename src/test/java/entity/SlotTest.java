package entity;

import enum_.ParkingCategory;
import enum_.VehicleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class SlotTest {
    @Test
    void shouldParkVehicleWhenTypeMatches() {
        Slot slot = new Slot(1, VehicleType.CAR);
        Vehicle car = new Vehicle("KA01", VehicleType.CAR, ParkingCategory.NORMAL);

        boolean result = slot.park(car);

        assertTrue(result);
        assertFalse(slot.isFree());
    }

    @Test
    void shouldNotParkWhenTypeMismatch() {
        Slot slot = new Slot(1, VehicleType.CAR);
        Vehicle bike = new Vehicle("KA02", VehicleType.BIKE, ParkingCategory.NORMAL);

        boolean result = slot.park(bike);

        assertFalse(result);
        assertTrue(slot.isFree());
    }

    @Test
    void shouldUnparkSuccessfully() {
        Slot slot = new Slot(1, VehicleType.CAR);
        Vehicle car = new Vehicle("KA02", VehicleType.CAR, ParkingCategory.NORMAL);

        slot.park(car);
        slot.unpark();

        assertTrue(slot.isFree());
    }

    @Test
    void shouldThrowExceptionIfUnparkIsFree() {
        Slot slot = new Slot(1, VehicleType.CAR);

        assertThrows(IllegalStateException.class, slot::unpark);
    }
}
