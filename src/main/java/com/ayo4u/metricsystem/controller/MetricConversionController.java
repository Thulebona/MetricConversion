package com.ayo4u.metricsystem.controller;

import com.ayo4u.metricsystem.model.OutputResponse;
import com.ayo4u.metricsystem.model.area.AreaInput;
import com.ayo4u.metricsystem.model.clock.TimeOrClockInput;
import com.ayo4u.metricsystem.model.length.LengthInput;
import com.ayo4u.metricsystem.model.temperature.TemperatureInput;
import com.ayo4u.metricsystem.model.weight.WeightInput;
import com.ayo4u.metricsystem.service.MetricConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MetricConversionController {

    @Autowired
    private MetricConversionService service;

    @PostMapping("length")
    public OutputResponse convertLength(@RequestBody LengthInput lengthInput) {
        return service.convertLength(lengthInput);
    }

    @PostMapping("time")
    public OutputResponse convertTime(@RequestBody TimeOrClockInput clockInput) {
        return service.convertTimeOrClock(clockInput);
    }

    @PostMapping("temperature")
    public OutputResponse convertTemperature(@RequestBody TemperatureInput temperature) {
        return service.convertTemperature(temperature);
    }

    @PostMapping("area")
    public OutputResponse convertArea(@RequestBody AreaInput areaInput) {
        return service.convertArea(areaInput);
    }

    @PostMapping("weight")
    public OutputResponse convertWeight(@RequestBody WeightInput weightInput) {
        return service.convertMassOrWeight(weightInput);
    }


}
