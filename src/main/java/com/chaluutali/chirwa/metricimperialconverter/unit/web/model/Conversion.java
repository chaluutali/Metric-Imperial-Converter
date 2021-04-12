package com.chaluutali.chirwa.metricimperialconverter.unit.web.model;

import lombok.Data;

@Data
public class Conversion implements java.io.Serializable {
    private final String conversionType;
    private final double inputValue;
    private final String convertUnitFrom;
    private final String convertUnitTo;
}
