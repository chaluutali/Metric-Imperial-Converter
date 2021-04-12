package com.chaluutali.chirwa.metricimperialconverter.unit.web.service.validator;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.*;

public class ValidatorTest {
    @Test
    public void valid_test_Validator() {
        final ConversionDataValidator conversionDataValidator = new ConversionDataValidator();
        final Conversion mockAreaConversion = new Conversion("AREA",50,"m2","yd2");
        conversionDataValidator.validate(mockAreaConversion);
    }

    @Test
    public void invalid_test_validator() {
        final Conversion mockAreaConversion = new Conversion("AREAg",50,"m2","yd2");
        ConversionDataValidator Mock = mock(ConversionDataValidator.class);
        doThrow(ResponseStatusException.class)
                .when(Mock).validate(mockAreaConversion);
    }
}
