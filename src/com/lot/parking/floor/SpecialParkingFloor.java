package com.lot.parking.floor;

import com.lot.parking.VehicleType;
import com.lot.parking.division.Division;
import lombok.ToString;

@ToString
public class SpecialParkingFloor implements ParkingFloor {

    private int floorNumber;
    private int floorCapacity;
    private Division availableDivision;

    private SpecialParkingFloor(int floorNumber, int floorCapacity, Division availableDivision) {
        this.floorNumber = floorNumber;
        this.floorCapacity = floorCapacity;
        this.availableDivision = availableDivision;
    }

    public static ParkingFloor createParkingFloor(int floorNumber, int floorCapacity, Division availableDivision) {
        if (floorCapacity >= availableDivision.getAvailableCount()) {
            return new SpecialParkingFloor(floorNumber, floorNumber, availableDivision);
        } else {
            return null;
        }
    }

    @Override
    public int floorNumber() {
        return this.floorNumber;
    }

    @Override
    public int floorCapacity() {
        return this.floorCapacity;
    }

    @Override
    public int availableFloorCapacity() {
        return this.availableDivision.getAvailableCount();
    }

    @Override
    public boolean addVehicle(VehicleType vehicle) {
        if (this.availableFloorCapacity() >= 0) {
            this.availableDivision.setAvailableCount(this.availableDivision.getAvailableCount() - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeVehicle(VehicleType vehicle) {
        this.availableDivision.setAvailableCount(this.availableDivision.getAvailableCount() + 1);
        return true;
    }

    @Override
    public boolean isParkingLotFull() {
        return availableFloorCapacity() == 0;
    }
}
