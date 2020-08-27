package com.lot.parking.division;

import lombok.Data;

@Data
public class BikeDivision extends Division{
    public BikeDivision(int availableCount) {
        super(availableCount);
    }
}
