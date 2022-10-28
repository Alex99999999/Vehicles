package com.vehicles.generator.writers.filewriter.csv;

import com.vehicles.generator.dto.VehicleDto;
import com.vehicles.generator.writers.filewriter.AbstractFileWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.StringJoiner;

@Component
public abstract class AbstractCsvFileWriter extends AbstractFileWriter {

    protected static final String HEADERS = "number;type;color;fabricationDate;";

    public abstract String write(List<VehicleDto> list);

    protected abstract String setSpecificFields(VehicleDto dto);

    protected void setFields(List<VehicleDto> dtoList, String specificHeaders) {
        lineList.add(HEADERS + specificHeaders);
        int increment = 1;
        for (VehicleDto dto : dtoList) {
            StringJoiner joiner = setCommonFields(dto, increment++);
            joiner.add(setSpecificFields(dto));
            lineList.add(joiner.toString());
        }
    }

    private StringJoiner setCommonFields(VehicleDto dto, int increment) {
        StringJoiner joiner = new StringJoiner(";");
        return joiner
                .add(String.valueOf(increment))
                .add(dto.getType())
                .add(dto.getColor())
                .add(String.valueOf(dto.getFabricationDate()));
    }

}
