package com.lot.parking;

import com.lot.parking.division.*;
import com.lot.parking.floor.GeneralParkingFloor;
import com.lot.parking.floor.ParkingFloor;
import com.lot.parking.floor.SpecialParkingFloor;

public class ParkingLotSystemDesign {

    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("Madhav Jangala Parking Lot", createAddress());
        ParkingFloor parkingFloor = GeneralParkingFloor.createParkingFloor(1, 100, new FloorDivision(25,25,25,25));
        ParkingFloor bikeParkingFloor = SpecialParkingFloor.createParkingFloor(2, 100, new BikeDivision(100));
        ParkingFloor carParkingFloor = SpecialParkingFloor.createParkingFloor(2, 100, new CarDivision(100));
        ParkingFloor truckParkingFloor = SpecialParkingFloor.createParkingFloor(2, 100, new TruckDivision(100));
        ParkingFloor electricParkingFloor = SpecialParkingFloor.createParkingFloor(2, 100, new ElectricDivision(100));
        parkingLot.addFloor(parkingFloor);
        parkingLot.addFloor(bikeParkingFloor);
        parkingLot.addFloor(carParkingFloor);
        parkingLot.addFloor(truckParkingFloor);
        parkingLot.addFloor(electricParkingFloor);

        System.out.println("parking Lot is set:" + parkingLot);

        addVehicle(parkingLot, VehicleType.CAR);
        addVehicle(parkingLot, VehicleType.MOTORBIKE);
        addVehicle(parkingLot, VehicleType.ELECTRIC);
        addVehicle(parkingLot, VehicleType.TRUCK);

        System.out.println("After Parking Lot is occupied: "+parkingLot);

        removeVehicle(parkingLot, VehicleType.TRUCK);

        System.out.println("After Vehicle left: " + parkingLot);
    }

    private static boolean addVehicle(ParkingLot parkingLot, VehicleType vehicleType) {
        return parkingLot.getFloors()
                .stream()
                .anyMatch(i->i.addVehicle(vehicleType));
    }

    private static boolean removeVehicle(ParkingLot parkingLot, VehicleType vehicleType) {
        return parkingLot.getFloors()
                .stream()
                .anyMatch(i->i.removeVehicle(vehicleType));
    }

    private static Address createAddress() {
        return Address.builder()
                .addressLine1("Address Line 1")
                .addressLine2("Address Line 2")
                .pin(500070L)
                .city("Hyderabad")
                .state("Telangana")
                .country("India")
                .build();
    }

}
