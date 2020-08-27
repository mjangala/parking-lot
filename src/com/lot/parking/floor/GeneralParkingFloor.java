package com.lot.parking.floor;

import com.lot.parking.VehicleType;
import com.lot.parking.division.FloorDivision;
import lombok.ToString;

@ToString
public class GeneralParkingFloor implements ParkingFloor {

    private int floorNumber;
    private int floorCapacity;
    private FloorDivision availableDivision;

    private GeneralParkingFloor(int floorNumber, int floorCapacity, FloorDivision availableDivision) {
        this.floorNumber = floorNumber;
        this.floorCapacity = floorCapacity;
        this.availableDivision = availableDivision;
    }

    public static ParkingFloor createParkingFloor(int floorNumber, int floorCapacity, FloorDivision availableDivision) {
        if (floorCapacity >= availableDivision.getCount())
            return new GeneralParkingFloor(floorNumber, floorNumber, availableDivision);
        else
            return null;
    }

    @Override
    public int floorNumber() {
        return floorNumber;
    }

    @Override
    public int floorCapacity() {
        return floorCapacity;
    }

    @Override
    public int availableFloorCapacity() {
        return availableDivision.getBikesCount()
                + availableDivision.getCarCount()
                + availableDivision.getElectricCount()
                + availableDivision.getTruckCount();
    }

    @Override
    public boolean addVehicle(VehicleType vehicle) {
        boolean result = true;
        if (vehicle == VehicleType.ELECTRIC && availableDivision.getElectricCount() > 0) {
            availableDivision.setElectricCount(availableDivision.getElectricCount() - 1);
        } else if (vehicle == VehicleType.MOTORBIKE && availableDivision.getBikesCount() > 0) {
            availableDivision.setBikesCount(availableDivision.getBikesCount() - 1);
        } else if (vehicle == VehicleType.CAR && availableDivision.getCarCount() > 0) {
            availableDivision.setCarCount(availableDivision.getCarCount() - 1);
        } else if (vehicle == VehicleType.TRUCK && availableDivision.getTruckCount() > 0) {
            availableDivision.setTruckCount(availableDivision.getTruckCount() - 1);
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean removeVehicle(VehicleType vehicle) {
        boolean result = true;
        if (vehicle == VehicleType.ELECTRIC && availableDivision.getElectricCount() > 0) {
            availableDivision.setElectricCount(availableDivision.getElectricCount() + 1);
        } else if (vehicle == VehicleType.MOTORBIKE && availableDivision.getBikesCount() > 0) {
            availableDivision.setBikesCount(availableDivision.getBikesCount() + 1);
        } else if (vehicle == VehicleType.CAR && availableDivision.getCarCount() > 0) {
            availableDivision.setCarCount(availableDivision.getCarCount() + 1);
        } else if (vehicle == VehicleType.TRUCK && availableDivision.getTruckCount() > 0) {
            availableDivision.setTruckCount(availableDivision.getTruckCount() + 1);
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean isParkingLotFull() {
        return availableFloorCapacity() == 0;
    }

    public boolean hasElectricSpots() {
        return availableDivision.getElectricCount() > 0;
    }

    public boolean hasSpotsForTrucks() {
        return availableDivision.getCarCount() > 0;
    }

    public boolean hasSpotsForCars() {
        return availableDivision.getTruckCount() > 0;
    }

    public boolean hasSpotsForBikes() {
        return availableDivision.getBikesCount() > 0;
    }
}
