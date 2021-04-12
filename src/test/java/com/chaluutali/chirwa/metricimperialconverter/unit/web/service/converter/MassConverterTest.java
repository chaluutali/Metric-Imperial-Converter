package com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter.MassConverter;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class MassConverterTest {
    @Test
    public void testConvert() {
        final MassConverter massConverter = new MassConverter();
        final Conversion mockMassConversion = new Conversion("MASS",100000000,"lb","kg");
        final ResponseEntity<ConversionResult> conversionResultResponseEntity = massConverter.convert(mockMassConversion);
        assertThat(conversionResultResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(conversionResultResponseEntity.getBody()).getResult()).isEqualTo(1.0000000000000001E8);
        assertThat(conversionResultResponseEntity.getBody().getUnit()).isEqualTo("kg");
    }
}
