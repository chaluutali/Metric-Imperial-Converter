package com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class VolumeConverterTest {
    @Test
    public void testConvert() {
        final VolumeConverter volumeConverter = new VolumeConverter();
        final Conversion mockVolumeConversion = new Conversion("VOLUME",1000000000,"in3","l");
        final ResponseEntity<ConversionResult> conversionResultResponseEntity = volumeConverter.convert(mockVolumeConversion);
        assertThat(conversionResultResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(conversionResultResponseEntity.getBody()).getResult()).isEqualTo(1.6387059997401997E7);
        assertThat(conversionResultResponseEntity.getBody().getUnit()).isEqualTo("l");
    }
}
