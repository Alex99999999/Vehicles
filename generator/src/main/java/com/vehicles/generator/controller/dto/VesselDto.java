package com.vehicles.generator.controller.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class VesselDto extends VehicleDto{

    private String capacity;

}
