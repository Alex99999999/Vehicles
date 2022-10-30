package com.vehicles.generator.controller.dto;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class VehicleDto {

   protected String type;
   protected String color;
   protected String fabricationDate;

}
