package com.vehicles.dto.request;

import com.vehicles.annotation.ValidateDate;
import com.vehicles.annotation.ValidateRgbColor;
import com.vehicles.domain.constants.CarBodyType;
import com.vehicles.domain.constants.VehicleType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CarRequestDto {

    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @NotNull(message = "Specify vehicle type")
    private VehicleType type;

    @NotNull(message = "Specify vehicle color")
    @ValidateRgbColor
    private String colour;

    @NotNull(message = "Specify vehicle color")
    @ValidateDate(pattern = DATE_PATTERN)
    private Date fabricationDate;

    @NotNull(message = "Specify vehicle color")
    private CarBodyType bodyType;

}
