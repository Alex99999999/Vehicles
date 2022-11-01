package com.vehicles.controller.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class VehicleRequestDto {

    protected String type;
    protected String color;
    protected String fabricationDate;

}
