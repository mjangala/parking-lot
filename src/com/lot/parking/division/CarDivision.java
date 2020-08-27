package com.lot.parking.division;

import lombok.Data;

@Data
public class CarDivision extends Division {
    public CarDivision(int availableCount) {
        super(availableCount);
    }
}
