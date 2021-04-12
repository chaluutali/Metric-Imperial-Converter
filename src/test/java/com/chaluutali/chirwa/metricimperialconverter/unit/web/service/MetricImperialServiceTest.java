package com.chaluutali.chirwa.metricimperialconverter.unit.web.service;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter.*;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.validator.ConversionDataValidator;
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
public class MetricImperialServiceTest {
    @InjectMocks
    MetricImperialService metricImperialService;
    @Mock
    private LengthConverter lengthConverter;
    @Mock
    private AreaConverter areaConverter;
    @Mock
    private VolumeConverter volumeConverter;
    @Mock
    private MassConverter massConverter;
    @Mock
    private TemperatureConverter temperatureConverter;
    @Mock
    private ConversionDataValidator conversionDataValidator;

    @Test
    public void valid_MetricServiceConverters_test(){
        //
        // Given
        //
        final Conversion mockAreaConversion = new Conversion("AREA",50,"m2","yd2");
        final Conversion mockLengthConversion = new Conversion("LENGTH",0.1,"m","cm");
        final Conversion mockVolumeConversion = new Conversion("VOLUME",1000000000,"in3","l");
        final Conversion mockMassConversion = new Conversion("MASS",100000000,"lb","kg");
        final Conversion mockTemperatureConversion = new Conversion("TEMPERATURE",0,"C","F");
        when(areaConverter.convert(any(Conversion.class))).thenReturn(
                new ResponseEntity<>(ConversionResult.builder()
                        .result(59.7995)
                        .unit("yd2")
                        .build(), HttpStatus.OK));
        when(lengthConverter.convert(any(Conversion.class))).thenReturn(
                new ResponseEntity<>(ConversionResult.builder()
                        .result(10)
                        .unit("cm")
                        .build(), HttpStatus.OK));
        when(volumeConverter.convert(any(Conversion.class))).thenReturn(
                new ResponseEntity<>(ConversionResult.builder()
                        .result(16387064)
                        .unit("l")
                        .build(), HttpStatus.OK));
        when(massConverter.convert(any(Conversion.class))).thenReturn(
                new ResponseEntity<>(ConversionResult.builder()
                        .result(45359237)
                        .unit("kg")
                        .build(), HttpStatus.OK));
        when(temperatureConverter.convert(any(Conversion.class))).thenReturn(
                new ResponseEntity<>(ConversionResult.builder()
                        .result(32)
                        .unit("F")
                        .build(), HttpStatus.OK));
        //
        // When
        //
        final ResponseEntity<ConversionResult> areaResponseEntity = metricImperialService.performConversion(mockAreaConversion);
        final ResponseEntity<ConversionResult> lengthResponseEntity = metricImperialService.performConversion(mockLengthConversion);
        final ResponseEntity<ConversionResult> massResponseEntity = metricImperialService.performConversion(mockMassConversion);
        final ResponseEntity<ConversionResult> volumeResponseEntity = metricImperialService.performConversion(mockVolumeConversion);
        final ResponseEntity<ConversionResult> temperatureResponseEntity = metricImperialService.performConversion(mockTemperatureConversion);
        //
        // Then
        //
        //Area results
        assertThat(areaResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(areaResponseEntity.getBody()).getResult()).isEqualTo(59.7995);
        assertThat(areaResponseEntity.getBody().getUnit()).isEqualTo("yd2");
        //Length results
        assertThat(lengthResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(lengthResponseEntity.getBody()).getResult()).isEqualTo(10);
        assertThat(lengthResponseEntity.getBody().getUnit()).isEqualTo("cm");
        //mass results
        assertThat(massResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(massResponseEntity.getBody()).getResult()).isEqualTo(45359237);
        assertThat(massResponseEntity.getBody().getUnit()).isEqualTo("kg");
        //Volume results
        assertThat(volumeResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(volumeResponseEntity.getBody()).getResult()).isEqualTo(16387064);
        assertThat(volumeResponseEntity.getBody().getUnit()).isEqualTo("l");
        //Area results
        assertThat(temperatureResponseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(Objects.requireNonNull(temperatureResponseEntity.getBody()).getResult()).isEqualTo(32);
        assertThat(temperatureResponseEntity.getBody().getUnit()).isEqualTo("F");

    }
}
