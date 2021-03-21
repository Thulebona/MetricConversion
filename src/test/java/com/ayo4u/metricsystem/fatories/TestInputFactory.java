package com.ayo4u.metricsystem.fatories;

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

public class TestInputFactory {
    public static TemperatureInput getTemperatureInput(TemperatureUnit from, TemperatureUnit to, double value) {
        return TemperatureInput.builder().fromUnit(from).toUnit(to).value(value).build();
    }

    public static LengthInput getLengthInput(LengthUnit from, LengthUnit to, double value) {
        return LengthInput.builder().fromUnit(from).toUnit(to).value(value).build();
    }

    public static WeightInput getWeightInput(WeightUnit from, WeightUnit to, double value) {
        return WeightInput.builder().fromUnit(from).toUnit(to).value(value).build();
    }

    public static AreaInput getAreaInput(AreaUnit from, AreaUnit to, double value) {
        return AreaInput.builder().fromUnit(from).toUnit(to).value(value).build();
    }

    public static TimeOrClockInput getTimeOrClockInput(TimeOrClockUnit from, TimeOrClockUnit to, double value) {
        return TimeOrClockInput.builder().fromUnit(from).toUnit(to).value(value).build();
    }

    public static OutputResponse getExpected(String value) {
        return OutputResponse.builder().result(value).build();
    }

}
