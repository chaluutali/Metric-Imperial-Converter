package com.chaluutali.chirwa.metricimperialconverter.unit.web.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ConversionResult implements java.io.Serializable {
    private double result;
    private String unit;
}
