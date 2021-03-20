package com.ayo4u.metricsystem.service;


import com.ayo4u.metricsystem.model.OutputResponse;
import com.ayo4u.metricsystem.model.area.AreaInput;
import com.ayo4u.metricsystem.model.clock.TimeOrClockInput;
import com.ayo4u.metricsystem.model.length.LengthInput;
import com.ayo4u.metricsystem.model.temperature.TemperatureInput;
import com.ayo4u.metricsystem.model.weight.WeightInput;

public interface MetricConversionService {
    OutputResponse convertTemperature(TemperatureInput temp);

    OutputResponse convertLength(LengthInput length);

    OutputResponse convertArea(AreaInput area);

    OutputResponse convertMassOrWeight(WeightInput weight);

    OutputResponse convertTimeOrClock(TimeOrClockInput clock);

    OutputResponse formatOutput(String unitFormat);
}
