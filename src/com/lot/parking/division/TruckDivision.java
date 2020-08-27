package com.lot.parking.division;

import lombok.Data;

@Data
public class TruckDivision extends Division{
    public TruckDivision(int availableCount) {
        super(availableCount);
    }
}
