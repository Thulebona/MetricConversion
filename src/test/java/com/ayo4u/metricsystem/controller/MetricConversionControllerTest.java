package com.ayo4u.metricsystem.controller;

import com.ayo4u.metricsystem.model.InputUnitBase;
import com.ayo4u.metricsystem.model.OutputResponse;
import com.ayo4u.metricsystem.model.area.AreaInput;
import com.ayo4u.metricsystem.model.area.AreaUnit;
import com.ayo4u.metricsystem.model.clock.TimeOrClockInput;
import com.ayo4u.metricsystem.model.clock.TimeOrClockUnit;
import com.ayo4u.metricsystem.model.length.LengthInput;
import com.ayo4u.metricsystem.model.length.LengthUnit;
import com.ayo4u.metricsystem.model.temperature.TemperatureInput;
import com.ayo4u.metricsystem.model.temperature.TemperatureUnit;
import com.ayo4u.metricsystem.model.weight.WeightInput;
import com.ayo4u.metricsystem.model.weight.WeightUnit;
import com.ayo4u.metricsystem.service.MetricConversionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MetricConversionController.class)
class MetricConversionControllerTest {

    private String url;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    private InputUnitBase<?> inputRequest;
    private OutputResponse expectedResults;
    @MockBean
    private MetricConversionService serviceMockBean;



    @Test
    public void test_convertTemperature() throws Exception {
        url = "/temperature";
        inputRequest = TemperatureInput.builder()
                .fromUnit(TemperatureUnit.CELSIUS_UNIT)
                .toUnit(TemperatureUnit.KELVIN_UNIT)
                .value(50)
                .build();

        expectedResults = OutputResponse.builder().result("323.15K").build();
        when(serviceMockBean.convertTemperature(any())).thenReturn(expectedResults);

        assertExpectedResultsSame();
        verify(serviceMockBean).convertTemperature(any());
    }

    @Test
    public void test_convertLength() throws Exception {
        url = "/length";
        inputRequest = LengthInput.builder()
                .fromUnit(LengthUnit.METER_UNIT)
                .toUnit(LengthUnit.KILOMETER_UNIT)
                .value(50)
                .build();
        expectedResults = OutputResponse.builder().result("0.05km").build();
        when(serviceMockBean.convertLength(any())).thenReturn(expectedResults);

        assertExpectedResultsSame();
        verify(serviceMockBean).convertLength(any());
    }

    @Test
    public void test_convertTime() throws Exception {
        url = "/time";
        inputRequest = TimeOrClockInput.builder()
                .fromUnit(TimeOrClockUnit.SECOND_UNIT)
                .toUnit(TimeOrClockUnit.MINUTE_UNIT)
                .value(60)
                .build();
        expectedResults = OutputResponse.builder().result("1.0min").build();
        when(serviceMockBean.convertTimeOrClock(any())).thenReturn(expectedResults);

        assertExpectedResultsSame();
        verify(serviceMockBean).convertTimeOrClock(any());
    }

    @Test
    public void test_convertWeight() throws Exception {
        url = "/weight";
        inputRequest = WeightInput.builder()
                .fromUnit(WeightUnit.GRAM_UNIT)
                .toUnit(WeightUnit.KILOGRAM_UNIT)
                .value(10)
                .build();
        expectedResults = OutputResponse.builder().result("0.01kg").build();
        when(serviceMockBean.convertMassOrWeight(any())).thenReturn(expectedResults);

        assertExpectedResultsSame();
        verify(serviceMockBean).convertMassOrWeight(any());
    }


    @Test
    public void test_convertArea() throws Exception {
        url = "/area";
        inputRequest = AreaInput.builder()
                .fromUnit(AreaUnit.SQUARE_METER_UNIT)
                .toUnit(AreaUnit.SQUARE_FOOT_UNIT)
                .value(10)
                .build();
        expectedResults = OutputResponse.builder().result("10.0m²").build();
        when(serviceMockBean.convertArea(any())).thenReturn(expectedResults);

        assertExpectedResultsSame();
        verify(serviceMockBean).convertArea(any());
    }

    private void assertExpectedResultsSame() throws Exception {
        mockMvc.perform(post(url)
                .content(objectMapper.writeValueAsString(inputRequest))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResults),true))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
    }
}