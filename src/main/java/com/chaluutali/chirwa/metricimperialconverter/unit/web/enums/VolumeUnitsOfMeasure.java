package com.chaluutali.chirwa.metricimperialconverter.unit.web.enums;

import lombok.Getter;

public enum VolumeUnitsOfMeasure {

    CUBIC_METRE("m3",1),
    CUBIC_CENTIMETRE("cm3",1000000),
    CUBIC_DECIMETRE("dm3",1000),
    LITRE("l",1000),
    HECTOLITRES("hl",10),
    CUBIC_INCH("in3",61023.759),
    CUBIC_FEET("ft3",35.3146625),
    FLUID_OUNCE("fl oz",35195.0085),
    PINT("pt",1759.75043),
    GALLON("gal",219.968813),
    US_FLUID_OUNCE("US fl oz",33814.0222),
    US_PINT("US pt",2113.3763),
    US_GALLON("US gal",264.172037);

    @Getter
    private final String unit;
    @Getter
    private final double defaultValue;

    VolumeUnitsOfMeasure(final String unit, final double defaultValue) {
        this.unit = unit;
        this.defaultValue = defaultValue;
    }
}
