package com.chaluutali.chirwa.metricimperialconverter.unit.web.service.validator;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.enums.*;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Service
public class ConversionDataValidator {

    public void validate(final Conversion conversion) {
        validateStructure(conversion);
        validateBusinessLogic(conversion);
    }

    private void validateStructure(final Conversion conversion) {
        if (conversion.getConversionType().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conversion Archetype cannot be empty");
        }else if (conversion.getConvertUnitTo().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unit to convert to cannot be empty");
        }else if (conversion.getConvertUnitFrom().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unit to convert from cannot be empty");
        }
    }

    private void validateBusinessLogic(final Conversion conversion) {
        validateConversionType(conversion);
        if (conversion.getConversionType().equals(ConversionArchetype.LENGTH.name())) {
            validateLengthBusinessLogic(conversion);
        }else if (conversion.getConversionType().equals(ConversionArchetype.AREA.name())) {
            validateAreaBusinessLogic(conversion);
        }else if (conversion.getConversionType().equals(ConversionArchetype.MASS.name())) {
            validateMassBusinessLogic(conversion);
        }else if (conversion.getConversionType().equals(ConversionArchetype.TEMPERATURE.name())) {
            validateTemperatureBusinessLogic(conversion);
        }else if (conversion.getConversionType().equals(ConversionArchetype.VOLUME.name())) {
            validateVolumeBusinessLogic(conversion);
        }

    }

    private void validateVolumeBusinessLogic(final Conversion conversion) {
        Arrays.stream(VolumeUnitsOfMeasure.values())
                .filter(unit -> !(conversion.getConvertUnitTo().equals(unit.getUnit())) || !(conversion.getConvertUnitFrom().equals(unit.getUnit())))
                .forEach(invalidUnit -> {
                    if (!(Arrays.asList(VolumeUnitsOfMeasure.values()).contains(invalidUnit))) {
                        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Invalid Unit : " + invalidUnit.getUnit());
                    }
                });
    }

    private void validateTemperatureBusinessLogic(final Conversion conversion) {
        Arrays.stream(TemperatureUnitsOfMeasure.values())
                .filter(unit -> !(conversion.getConvertUnitTo().equals(unit.getUnit())) || !(conversion.getConvertUnitFrom().equals(unit.getUnit())))
                .forEach(invalidUnit -> {
                    if (!(Arrays.asList(TemperatureUnitsOfMeasure.values()).contains(invalidUnit))) {
                        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Invalid Unit : " + invalidUnit.getUnit());
                    }
                });
    }

    private void validateMassBusinessLogic(final Conversion conversion) {
        Arrays.stream(VolumeUnitsOfMeasure.values())
                .filter(unit -> !(conversion.getConvertUnitTo().equals(unit.getUnit())) || !(conversion.getConvertUnitFrom().equals(unit.getUnit())))
                .forEach(invalidUnit -> {
                    if (!(Arrays.asList(VolumeUnitsOfMeasure.values()).contains(invalidUnit))) {
                        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Invalid Unit : " + invalidUnit.getUnit());
                    }
                });
    }

    private void validateAreaBusinessLogic(final Conversion conversion) {
        Arrays.stream(AreaUnitsOfMeasure.values())
                .filter(unit -> !(conversion.getConvertUnitTo().equals(unit.getUnit())) || !(conversion.getConvertUnitFrom().equals(unit.getUnit())))
                .forEach(invalidUnit -> {
                    if (!(Arrays.asList(AreaUnitsOfMeasure.values()).contains(invalidUnit))) {
                        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Invalid Unit : " + invalidUnit.getUnit());
                    }
                });
    }

    private void validateConversionType(final Conversion conversion) {
        Arrays.stream(ConversionArchetype.values())
                .filter(archetype -> !(conversion.getConversionType().equals(archetype.name())))
                .forEach(invalidArchetype -> {
                    if (!(Arrays.asList(ConversionArchetype.values()).contains(invalidArchetype))) {
                        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Invalid Conversion Archetype specified : " + invalidArchetype.name());
                    }
                });
    }

    private void validateLengthBusinessLogic(final Conversion conversion) {
        Arrays.stream(LengthUnitsOfMeasure.values())
                .filter(unit -> !(conversion.getConvertUnitTo().equals(unit.getUnit())) || !(conversion.getConvertUnitFrom().equals(unit.getUnit())))
                .forEach(invalidUnit -> {
                    if (!(Arrays.asList(LengthUnitsOfMeasure.values()).contains(invalidUnit))) {
                        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Invalid Unit : " + invalidUnit.getUnit());
                    }
                });
    }
}
