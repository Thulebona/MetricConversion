package com.ayo4u.metricsystem.model.area;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.measure.Measure;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.unit.Unit;
import javax.measure.unit.UnitFormat;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;


@Getter
@AllArgsConstructor
public enum AreaUnit {
    SQUARE_METER_UNIT(SQUARE_METRE),
    SQUARE_KILOMETER_UNIT(toSquareMetre(KILOMETER)),
    SQUARE_MICROMETER_UNIT(toSquareMetre(METER.divide(1000000))),
    HECTARE_UNIT(HECTARE),
    SQUARE_MILE_UNIT(toSquareMetre(MILE)),
    SQUARE_YARD_UNIT(toSquareMetre(YARD)),
    SQUARE_FOOT_UNIT(toSquareMetre(FOOT)),
    SQUARE_INCH_UNIT(toSquareMetre(INCH)),
    ACRE_UNIT(SQUARE_METRE.times(4047));

    private final Unit<Area> unit;

    public static Unit<Area> toSquareMetre(Unit<Length> unit) {
        Unit<Area> sq = (Unit<Area>) unit.times(unit);
        return Measure.valueOf(1, SQUARE_METRE).to(sq).getUnit();
    }

    public String formatUnit() {
        return name().equals("ACRE_UNIT") ? "acre" : UnitFormat.getInstance().format(getUnit());
    }

}
