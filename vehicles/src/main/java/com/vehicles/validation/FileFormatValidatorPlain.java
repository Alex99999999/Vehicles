package com.vehicles.validation;

import com.vehicles.domain.constants.FileFormat;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@NoArgsConstructor
public class FileFormatValidatorPlain {
    public boolean isValid(String filePath) {
        boolean isValid = false;
        if (!filePath.isBlank()) {
            String fileFormat = filePath.substring(filePath.lastIndexOf(".") + 1);
            isValid = Arrays.stream(FileFormat.values())
                    .anyMatch(e -> e.name().equalsIgnoreCase(fileFormat));
        }
        return isValid;
    }

    //TODO delete
    public static void main(String[] args) {
        System.out.println(FileFormat.CSV.name());
//        Arrays.toString(FileFormat.values());
        System.out.println(Arrays.toString(FileFormat.values()));
    }

}
