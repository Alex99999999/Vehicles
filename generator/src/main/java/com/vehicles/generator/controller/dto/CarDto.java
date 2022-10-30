package com.vehicles.generator.controller.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CarDto extends VehicleDto {

    private String bodyType;

}
