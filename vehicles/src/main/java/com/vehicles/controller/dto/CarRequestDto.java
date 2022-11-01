package com.vehicles.controller.dto;

import com.vehicles.domain.constants.CarBodyType;
import lombok.Data;

@Data
public class CarRequestDto {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    private CarBodyType bodyType;

}
