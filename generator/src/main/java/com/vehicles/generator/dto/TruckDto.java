package com.vehicles.generator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TruckDto{

    private String type;
    private String color;
    private String fabricationDate;
    private String loadingCapacity;

}
