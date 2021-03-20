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
    SQUARE_KILOMETER_UNIT(squareMetre(KILOMETER)),
    SQUARE_MICROMETER_UNIT(squareMetre(METER.divide(1000000))),
    HECTARE_UNIT(HECTARE),
    SQUARE_MILE_UNIT(squareMetre(MILE)),
    SQUARE_YARD_UNIT(squareMetre(YARD)),
    SQUARE_FOOT_UNIT(squareMetre(FOOT)),
    SQUARE_INCH_UNIT(squareMetre(INCH)),
    ACRE_UNIT(SQUARE_METRE.times(4047));

    private final Unit<Area> unit;

    public static Unit<Area> squareMetre(Unit<Length> unit) {
        Unit<Area> sq = (Unit<Area>) unit.times(unit);
        return Measure.valueOf(1, SQUARE_METRE).to(sq).getUnit();
    }

    public String formatUnit() {
        return name().equalsIgnoreCase("ACRE_UNIT")
                ? "acre"
                : UnitFormat.getInstance().format(getUnit());
    }

}
