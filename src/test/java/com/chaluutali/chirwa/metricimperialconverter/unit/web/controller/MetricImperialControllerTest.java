package com.chaluutali.chirwa.metricimperialconverter.unit.web.controller;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.MetricImperialService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MetricImperialControllerTest {

    @InjectMocks
    MetricImperialController metricImperialController;

    @Mock
    MetricImperialService metricImperialService;

    @Test
    public void performConversionTest () {
        //
        // Given
        //
        final Conversion mockAreaConversion = new Conversion("AREA",50,"m2","yd2");
        when(metricImperialService.performConversion(any(Conversion.class))).thenReturn(
                new ResponseEntity<>(ConversionResult.builder()
                        .result(59.7995)
                        .unit("yd2")
                        .build(), HttpStatus.OK));
        //
        // When
        //
        final ResponseEntity<ConversionResult> conversionResultResponseEntity = metricImperialService.performConversion(mockAreaConversion);
        //
        // Then
        //
        assertThat(conversionResultResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(conversionResultResponseEntity.getBody()).getResult()).isEqualTo(59.7995);
        assertThat(conversionResultResponseEntity.getBody().getUnit()).isEqualTo("yd2");

    }

}
