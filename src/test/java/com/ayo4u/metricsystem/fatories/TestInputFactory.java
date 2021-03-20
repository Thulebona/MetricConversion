package com.ayo4u.metricsystem.fatories;

import com.ayo4u.metricsystem.model.OutputResponse;
import com.ayo4u.metricsystem.model.length.LengthInput;
import com.ayo4u.metricsystem.model.length.LengthUnit;
import com.ayo4u.metricsystem.model.temperature.TemperatureInput;
import com.ayo4u.metricsystem.model.temperature.TemperatureUnit;

public class TestInputFactory {
    public static TemperatureInput getTemperatureInput(TemperatureUnit from, TemperatureUnit to, double value) {
        return TemperatureInput.builder().fromUnit(from).toUnit(to).value(value).build();
    }
    public static LengthInput getLengthInput(LengthUnit from, LengthUnit to, double value) {
        return LengthInput.builder().fromUnit(from).toUnit(to).value(value).build();
    }
    public static OutputResponse getExpected(String value){
        return OutputResponse.builder().result(value).build();
    }

}
