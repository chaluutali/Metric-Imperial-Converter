package com.chaluutali.chirwa.metricimperialconverter.unit.web.enums;

import lombok.Getter;

public enum TemperatureUnitsOfMeasure {

    KELVIN("K"),
    CELSIUS("C"),
    FAHRENHEIT("F");

    @Getter
    private final String unit;

    TemperatureUnitsOfMeasure(final String unit) {
        this.unit = unit;
    }
}
