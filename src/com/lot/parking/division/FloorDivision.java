package com.lot.parking.division;

import lombok.Data;

@Data
public class FloorDivision {
    private int bikesCount;
    private int carCount;
    private int truckCount;
    private int electricCount;

    public FloorDivision(int bikesCount, int carCount, int truckCount, int electricCount) {
        this.bikesCount = bikesCount;
        this.carCount = carCount;
        this.truckCount = truckCount;
        this.electricCount = electricCount;
    }

    public int getCount() {
        return bikesCount + carCount + truckCount + electricCount;
    }
}
