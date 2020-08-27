package com.lot.parking.floor;

import com.lot.parking.VehicleType;

public interface ParkingFloor {

    int floorNumber();

    int floorCapacity();

    int availableFloorCapacity();

    boolean addVehicle(VehicleType vehicle);

    boolean removeVehicle(VehicleType vehicle);

    boolean isParkingLotFull();
}
