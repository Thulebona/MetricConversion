package com.ayo4u.metricsystem.model.length;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.measure.quantity.Length;
import javax.measure.unit.Unit;
import javax.measure.unit.UnitFormat;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;

@Getter
@AllArgsConstructor
public enum LengthUnit {
    METER_UNIT(METRE),
    KILOMETER_UNIT(KILOMETER),
    CENTIMETER_UNIT(CENTIMETER),
    MILLIMETER_UNIT(MILLIMETER),
    MILE_UNIT(MILE),
    YARD_UNIT(YARD),
    FOOT_UNIT(FOOT),
    INCH_UNIT(INCH),
    LIGHT_YEAR_UNIT(LIGHT_YEAR);
    private final Unit<Length> unit;

    public String formatUnit() {
        return UnitFormat.getInstance().format(this.getUnit());
    }
}
