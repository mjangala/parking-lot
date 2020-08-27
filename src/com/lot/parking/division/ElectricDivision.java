package com.lot.parking.division;

import lombok.Data;

@Data
public class ElectricDivision extends Division {
    public ElectricDivision(int availableCount) {
        super(availableCount);
    }
}
