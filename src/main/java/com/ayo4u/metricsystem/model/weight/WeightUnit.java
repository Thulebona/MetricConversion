package com.ayo4u.metricsystem.model.weight;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.measure.quantity.Mass;
import javax.measure.unit.Unit;
import javax.measure.unit.UnitFormat;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;

@Getter
@AllArgsConstructor
public enum WeightUnit {

    GRAM_UNIT(GRAM),
    KILOGRAM_UNIT(KILOGRAM),
    MILLIGRAM_UNIT(MILLI(GRAM)),
    METRICTON_US_UNIT(TON_US),
    METRICTON_UK_UNIT(TON_UK),
    POUND_UNIT(POUND),
    CARAT_UNIT(GRAM.times(0.2).asType(Mass.class)),
    OUNCE_UNIT(OUNCE);

    private final Unit<Mass> unit;

    public String formatUnit() {
        return name().equals("CARAT_UNIT") ? "ct" : UnitFormat.getInstance().format(this.getUnit());
    }
}
