package com.chaluutali.chirwa.metricimperialconverter.unit.web.controller;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.ConversionResult;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.MetricImperialService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MetricImperialController {

    @Autowired
    private final MetricImperialService metricImperialService;

    @RequestMapping(method = RequestMethod.POST, value = "/convert", headers="Accept=application/json", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ConversionResult> performConversion(@RequestBody final Conversion conversion)  {
        return metricImperialService.performConversion(conversion);
    }

}
