package com.chaluutali.chirwa.metricimperialconverter.unit.web.enums;

import lombok.Getter;

public enum MassUnitsOfMeasure {

    MILLIGRAM("mg",1),
    GRAM("g",0.001),
    KILOGRAM("kg",0.00001),
    TONNE("t", 0.00001),
    OUNCE("oz",0.00003527),
    POUND("lb",0.00001),
    STONES("s", 0.00001),
    UK_HUNDRED_WEIGHT("cwt",0.00001),
    UK_LONG_TON("",0.00001);

    @Getter
    private final String unit;
    @Getter
    private final double defaultValue;

    MassUnitsOfMeasure(final String unit, final double defaultValue) {
        this.unit = unit;
        this.defaultValue = defaultValue;
    }
}
