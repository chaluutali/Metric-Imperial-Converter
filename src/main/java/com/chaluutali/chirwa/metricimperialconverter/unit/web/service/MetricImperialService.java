package com.chaluutali.chirwa.metricimperialconverter.unit.web.service;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter.*;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.validator.ConversionDataValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static com.chaluutali.chirwa.metricimperialconverter.unit.web.enums.ConversionArchetype.*;

@Service
@AllArgsConstructor
public class MetricImperialService {
    @Autowired
    private  final LengthConverter lengthConverter;
    @Autowired
    private final AreaConverter areaConverter;
    @Autowired
    private final VolumeConverter volumeConverter;
    @Autowired
    private final MassConverter massConverter;
    @Autowired
    private final TemperatureConverter temperatureConverter;
    @Autowired
    private final ConversionDataValidator conversionDataValidator;

    public ResponseEntity<ConversionResult> performConversion(final Conversion conversion) {
        conversionDataValidator.validate(conversion);
        if (conversion.getConversionType().equals(LENGTH.name())) {
            return lengthConverter.convert(conversion);
        }else if (conversion.getConversionType().equals(AREA.name())) {
            return areaConverter.convert(conversion);
        }else if (conversion.getConversionType().equals(VOLUME.name())) {
            return volumeConverter.convert(conversion);
        }else if (conversion.getConversionType().equals(MASS.name())) {
            return massConverter.convert(conversion);
        }else if (conversion.getConversionType().equals(TEMPERATURE.name())) {
            return temperatureConverter.convert(conversion);
        }
        throw new ResponseStatusException(HttpStatus.METHOD_NOT_ALLOWED, "Conversion Type Not Allowed : " + conversion.getConversionType());
    }
}
