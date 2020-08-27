package com.lot.parking;

import com.lot.parking.floor.ParkingFloor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class ParkingLot {

    private final int MAX_NUMBER_OF_FLOORS = 10;

    private final String parkingLotName;
    private final Address address;
    private final List<ParkingFloor> floors;

    public ParkingLot(String parkingLotName, Address address) {
        this.parkingLotName = parkingLotName;
        this.address = address;
        this.floors = new ArrayList<>();
    }

    public boolean addFloor(ParkingFloor floor) {
        boolean result = false;
        if (floors.size() <= MAX_NUMBER_OF_FLOORS) result = floors.add(floor);
        floors.sort(Comparator.comparing(ParkingFloor::floorNumber));
        return result;
    }
}
