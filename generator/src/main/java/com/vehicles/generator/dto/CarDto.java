package com.vehicles.generator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {

    private String type;
    private String color;
    private String fabricationDate;
    private String bodyType;

}
