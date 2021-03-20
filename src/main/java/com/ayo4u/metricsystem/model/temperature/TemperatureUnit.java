package com.ayo4u.metricsystem.model.temperature;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.measure.quantity.Temperature;
import javax.measure.unit.Unit;
import javax.measure.unit.UnitFormat;

import static javax.measure.unit.NonSI.FAHRENHEIT;
import static javax.measure.unit.SI.CELSIUS;
import static javax.measure.unit.SI.KELVIN;

@Getter
@AllArgsConstructor
public enum TemperatureUnit {
    CELSIUS_UNIT(CELSIUS),
    KELVIN_UNIT(KELVIN),
    FAHRENHEIT_UNIT(FAHRENHEIT);
    private final Unit<Temperature> unit;

    public String formatUnit() {
        return UnitFormat.getInstance().format(this.getUnit());
    }
}
