package com.lot.parking;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Address {
    private String addressLine1;
    private String addressLine2;
    private Long pin;
    private String city;
    private String state;
    private String country;
}
