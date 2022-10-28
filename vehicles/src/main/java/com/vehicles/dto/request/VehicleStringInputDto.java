package com.vehicles.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleStringInputDto {

    protected String type;
    protected String color;

    protected String fabricationDate;

    protected String bodyType;

    protected String loadingCapacity;

}
