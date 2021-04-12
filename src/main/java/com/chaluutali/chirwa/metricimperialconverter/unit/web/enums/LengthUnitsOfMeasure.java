package com.chaluutali.chirwa.metricimperialconverter.unit.web.enums;

import lombok.Getter;

public enum LengthUnitsOfMeasure {
    INCH("in", 39.3700787),
    FEET("ft",3.2808399),
    MILE("mi",0.000621371192),
    MILLIMETRE("mm", 1000),
    CENTIMETRE("cm", 100),
    METRE("m", 1),
    KILOMETRE("km",0.001),
    YARD("yd",1.0936133);

    @Getter
    private final String unit;
    @Getter
    private final double defaultValue;

    LengthUnitsOfMeasure(final String unit, final double defaultValue) {
        this.unit = unit;
        this.defaultValue = defaultValue;
    }

}
