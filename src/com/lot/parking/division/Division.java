package com.lot.parking.division;

import lombok.Data;

@Data

public class Division {
    private int availableCount;

    public Division(int availableCount) {
        this.availableCount = availableCount;
    }
}
