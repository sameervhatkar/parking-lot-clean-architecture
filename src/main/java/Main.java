import controller.ParkingCLIController;
import core.ParkingLot;
import entity.Floor;
import entity.Slot;
import repository.InMemoryTicketRepo;
import repository.TicketRepo;
import service.ParkingService;
import strategy.*;
import enum_.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        int totalFloors = 3;
        int slotsPerFloor = 10;
        int slotsPerVIPFloor = 5;

        Floor[] floors = new Floor[totalFloors];
        for(int i = 0; i < totalFloors; i++) {
            boolean isVIPFloor = (i == totalFloors - 1);

            Slot[] slots;
            if(isVIPFloor)
                slots = createVIPSlots(slotsPerVIPFloor);
            else
                slots = createNormalSlots(slotsPerFloor);

            floors[i] = new Floor(i+1, slots, isVIPFloor);
        }

        Map<VehicleType, Double> ratePerHour = new HashMap<>();
        ratePerHour.put(VehicleType.BIKE, 20.0);
        ratePerHour.put(VehicleType.CAR, 40.0);
        ParkingStrategy strategy = new FirstAvailableStrategy();
        TicketRepo ticketRepo = new InMemoryTicketRepo();
        ParkingLot parkingLot = new ParkingLot(floors, strategy);
        PricingStrategy pricingStrategy = new VehicleTypePricingStrategy(ratePerHour);
        ParkingService parkingService = new ParkingService(parkingLot, ticketRepo, pricingStrategy);
        ParkingCLIController parkingCLIController = new ParkingCLIController(parkingService);

        parkingCLIController.start();
    }

    private static Slot[] createNormalSlots(int count) {
        Slot[] slots = new Slot[count];

        for(int i = 0; i < count; i++) {
            if(i % 2 == 0)
                slots[i] = new Slot(i + 1, VehicleType.CAR);
            else
                slots[i] = new Slot(i + 1, VehicleType.BIKE);
        }
        return slots;
    }

    private static Slot[] createVIPSlots(int count) {
        Slot[] slots = new Slot[count];

        for(int i = 0; i < count; i++) {
            if(i < 2)
                slots[i] = new Slot(i+1, VehicleType.BIKE);
            else
                slots[i] = new Slot(i+1, VehicleType.CAR);
        }
        return slots;

    }

}