package com.chaluutali.chirwa.metricimperialconverter.integration;

import com.chaluutali.chirwa.metricimperialconverter.unit.web.controller.MetricImperialController;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.model.Conversion;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.MetricImperialService;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.converter.*;
import com.chaluutali.chirwa.metricimperialconverter.unit.web.service.validator.ConversionDataValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MetricImperialController.class,
        AreaConverter.class,
        LengthConverter.class,
        MassConverter.class,
        TemperatureConverter.class,
        VolumeConverter.class,
        ConversionDataValidator.class,
        MetricImperialService.class})
@WebAppConfiguration
@WebMvcTest(MetricImperialController.class)
public class MetricImperialConverterIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void givenWac_whenServletContext_thenItProvidesMetricImperialController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
        Assert.assertNotNull(webApplicationContext.getBean("metricImperialController"));
        Assert.assertNotNull(webApplicationContext.getBean("metricImperialService"));
    }

    @Test
    public void givenConvertPost_whenMockMVC_thenVerifyResponse() throws Exception {
        Conversion mockAreaConversion = new Conversion("AREA",50,"m2","yd2");
        this.mockMvc.perform( MockMvcRequestBuilders
                .post("/convert")
                .content(asJsonString(mockAreaConversion))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(59.7995025));
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
