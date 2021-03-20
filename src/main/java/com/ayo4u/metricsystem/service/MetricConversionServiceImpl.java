package com.ayo4u.metricsystem.service;

import com.ayo4u.metricsystem.model.OutputResponse;
import com.ayo4u.metricsystem.model.area.AreaInput;
import com.ayo4u.metricsystem.model.clock.TimeOrClockInput;
import com.ayo4u.metricsystem.model.length.LengthInput;
import com.ayo4u.metricsystem.model.temperature.TemperatureInput;
import com.ayo4u.metricsystem.model.weight.WeightInput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Service
public class MetricConversionServiceImpl implements MetricConversionService {

    private double result = 0;
    @Value("${output.max.fraction.digit}")
    private int maxFractionDigits;

    @Override
    public OutputResponse convertTemperature(TemperatureInput temp) {
        result = temp.getFromUnit()
                .getUnit()
                .getConverterTo(temp.getToUnit().getUnit())
                .convert(temp.getValue());

        return formatOutput(temp.getToUnit().formatUnit());
    }

    @Override
    public OutputResponse convertLength(LengthInput length) {
        result = length.getFromUnit()
                .getUnit()
                .getConverterTo(length.getToUnit().getUnit())
                .convert(length.getValue());

        return formatOutput(length.getToUnit().formatUnit());
    }

    @Override
    public OutputResponse convertArea(AreaInput area) {
        result = area.getFromUnit()
                .getUnit()
                .getConverterTo(area.getToUnit().getUnit())
                .convert(area.getValue());

        return formatOutput(area.getToUnit().formatUnit());
    }

    @Override
    public OutputResponse convertMassOrWeight(WeightInput weight) {
        result = weight.getFromUnit()
                .getUnit()
                .getConverterTo(weight.getToUnit().getUnit())
                .convert(weight.getValue());

        return formatOutput(weight.getToUnit().formatUnit());
    }

    @Override
    public OutputResponse convertTimeOrClock(TimeOrClockInput clock) {
        result = clock.getFromUnit()
                .getUnit()
                .getConverterTo(clock.getToUnit().getUnit())
                .convert(clock.getValue());

        return formatOutput(clock.getToUnit().formatUnit());
    }

    @Override
    public OutputResponse formatOutput(String symbol) {
        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(maxFractionDigits);
        String msg = String.format("%s %s", df.format(result), symbol);
        return OutputResponse.builder()
                .result(msg)
                .build();
    }

}
