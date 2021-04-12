package com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.enums.TemperatureUnitsOfMeasure;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;

@Service
public class TemperatureConverter {
    public ResponseEntity<ConversionResult> convert(final Conversion conversion) {
        final TemperatureUnitsOfMeasure unitFrom = Arrays.stream(TemperatureUnitsOfMeasure.values())
                .filter(unit -> unit.getUnit().equals(conversion.getConvertUnitFrom()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Unit Not Allowed : " + conversion.getConvertUnitFrom()));
        return process(unitFrom, conversion);
    }

    private ResponseEntity<ConversionResult> process(final TemperatureUnitsOfMeasure unitFrom, final Conversion conversion) {
        return new ResponseEntity<>(ConversionResult.builder()
                .result(calculate(unitFrom, conversion))
                .unit(conversion.getConvertUnitTo())
                .build(), HttpStatus.OK);
    }

    private double calculate(final TemperatureUnitsOfMeasure unitFrom, final Conversion conversion) {
        if (conversion.getConvertUnitFrom().equals(conversion.getConvertUnitTo())) {
            return conversion.getInputValue();
        }
        final TemperatureUnitsOfMeasure unitTo = Arrays.stream(TemperatureUnitsOfMeasure.values())
                .filter(unit -> unit.getUnit().equals(conversion.getConvertUnitTo()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Unit Not Allowed : " + conversion.getConvertUnitTo()));
        return doConversion(unitFrom, unitTo, conversion);
    }

    private double doConversion(final TemperatureUnitsOfMeasure unitFrom, final TemperatureUnitsOfMeasure unitTo, final Conversion conversion) {

                    if (unitFrom.getUnit().equals(TemperatureUnitsOfMeasure.KELVIN.getUnit()) && unitTo.getUnit().equals(TemperatureUnitsOfMeasure.CELSIUS.getUnit())) {
                        return (conversion.getInputValue() - 273.15);
                    }else if (unitFrom.getUnit().equals(TemperatureUnitsOfMeasure.CELSIUS.getUnit()) && unitTo.getUnit().equals(TemperatureUnitsOfMeasure.KELVIN.getUnit())) {
                        return (conversion.getInputValue() + 273.15);
                    }else if (unitFrom.getUnit().equals(TemperatureUnitsOfMeasure.KELVIN.getUnit()) && unitTo.getUnit().equals(TemperatureUnitsOfMeasure.FAHRENHEIT.getUnit())) {
                        return (((conversion.getInputValue() - 273.15) * 1.8) + 32);
                    }else if (unitFrom.getUnit().equals(TemperatureUnitsOfMeasure.CELSIUS.getUnit()) && unitTo.getUnit().equals(TemperatureUnitsOfMeasure.FAHRENHEIT.getUnit())) {
                        return ((conversion.getInputValue() * 1.8) + 32);
                    }else if (unitFrom.getUnit().equals(TemperatureUnitsOfMeasure.FAHRENHEIT.getUnit()) && unitTo.getUnit().equals(TemperatureUnitsOfMeasure.KELVIN.getUnit())) {
                        return (((conversion.getInputValue() -  32) / 1.8) + 273.15);
                    }else if (unitFrom.getUnit().equals(TemperatureUnitsOfMeasure.FAHRENHEIT.getUnit()) && unitTo.getUnit().equals(TemperatureUnitsOfMeasure.CELSIUS.getUnit())) {
                        return ((conversion.getInputValue() - 32) / 1.8);
                    }
                throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Unit Not Allowed : " + conversion.getConvertUnitFrom());
    }
}
