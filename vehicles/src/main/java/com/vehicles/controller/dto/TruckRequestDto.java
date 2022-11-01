package com.vehicles.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TruckRequestDto {

   @NotNull(message = "Specify vehicle color")
   private String loadingCapacity;

}
