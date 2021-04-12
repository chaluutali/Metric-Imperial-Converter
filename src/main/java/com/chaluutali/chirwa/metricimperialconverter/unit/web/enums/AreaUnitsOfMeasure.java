package com.chaluutali.chirwa.metricimperialconverter.unit.web.enums;

import lombok.Getter;

public enum AreaUnitsOfMeasure {
    SQUARE_METRE("m2",1),
    SQUARE_MILLIMETRE("mm2", 1000000),
    SQUARE_CENTIMETRE("cm2", 10000),
    HECTARE("ha",0.0001),
    SQUARE_KILOMETRE("km2",0.000001),
    SQUARE_INCH("in2", 1550.0031),
    SQUARE_FEET("sq ft", 10.7639104),
    SQUARE_YARD("yd2", 1.19599005),
    ACRE("a", 0.000247105382),
    SQUARE_MILE("ml2",0.00001);

    @Getter
    private final String unit;
    @Getter
    private final double defaultValue;

    AreaUnitsOfMeasure(final String unit, final double defaultValue) {
        this.unit = unit;
        this.defaultValue = defaultValue;
    }
}
