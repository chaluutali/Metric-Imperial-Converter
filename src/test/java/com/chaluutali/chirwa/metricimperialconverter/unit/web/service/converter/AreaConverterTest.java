package com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter.AreaConverter;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AreaConverterTest {
    @Test
    public void testConvert() {
        final AreaConverter areaConverter = new AreaConverter();
        final Conversion mockAreaConversion = new Conversion("AREA",50,"m2","yd2");
        final ResponseEntity<ConversionResult> conversionResultResponseEntity = areaConverter.convert(mockAreaConversion);
        assertThat(conversionResultResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(conversionResultResponseEntity.getBody()).getResult()).isEqualTo(59.7995025);
        assertThat(conversionResultResponseEntity.getBody().getUnit()).isEqualTo("yd2");
    }
}
