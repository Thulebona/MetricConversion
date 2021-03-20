package com.ayo4u.metricsystem.model.clock;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.measure.Unit;
import javax.measure.quantity.Time;
import javax.measure.unit.UnitFormat;

import static tec.units.ri.unit.Units.*;


@Getter
@AllArgsConstructor
public enum TimeOrClockUnit {
    SECOND_UNIT(SECOND),
    MINUTE_UNIT(MINUTE),
    HOUR_UNIT(HOUR),
    DAY_UNIT(DAY),
    WEEK_UNIT(WEEK),
    YEAR_UNIT(YEAR);

    private final Unit<Time> unit;

    public String formatUnit() {
        return UnitFormat.getInstance().format(this.getUnit());
    }
}
