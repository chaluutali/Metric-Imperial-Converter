package com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter.TemperatureConverter;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class TemperatureConverterTest {
    @Test
    public void testConvert() {
        final TemperatureConverter temperatureConverter = new TemperatureConverter();
        final Conversion mockTemperatureConversion = new Conversion("TEMPERATURE",0,"C","F");
        final ResponseEntity<ConversionResult> conversionResultResponseEntity = temperatureConverter.convert(mockTemperatureConversion);
        assertThat(conversionResultResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(conversionResultResponseEntity.getBody()).getResult()).isEqualTo(32);
        assertThat(conversionResultResponseEntity.getBody().getUnit()).isEqualTo("F");
    }
}
