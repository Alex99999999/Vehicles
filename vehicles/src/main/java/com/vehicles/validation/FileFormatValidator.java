package com.vehicles.validation;

import com.vehicles.constants.FileFormat;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@NoArgsConstructor
public class FileFormatValidator {
    public boolean isValid(String filePath) {
        boolean isValid = false;
        if (!filePath.isBlank()) {
            String fileFormat = filePath.substring(filePath.lastIndexOf(".") + 1);
            isValid = Arrays.stream(FileFormat.values())
                    .anyMatch(e -> e.name().equalsIgnoreCase(fileFormat));
        }
        return isValid;
    }

}
