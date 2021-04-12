package com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter.LengthConverter;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class LengthConverterTest {
    @Test
    public void testConvert() {
        final LengthConverter lengthConverter = new LengthConverter();
        final Conversion mockLengthConversion = new Conversion("LENGTH",0.1,"m","cm");
        final ResponseEntity<ConversionResult> conversionResultResponseEntity = lengthConverter.convert(mockLengthConversion);
        assertThat(conversionResultResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(conversionResultResponseEntity.getBody()).getResult()).isEqualTo(10);
        assertThat(conversionResultResponseEntity.getBody().getUnit()).isEqualTo("cm");
    }
}
