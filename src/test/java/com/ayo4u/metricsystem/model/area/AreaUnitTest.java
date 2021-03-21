package com.ayo4u.metricsystem.model.area;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ayo4u.metricsystem.model.area.AreaUnit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AreaUnitTest {


    @ParameterizedTest
    @EnumSource(AreaUnit.class)
    void testThatAreaUnitNameEndsWith__UNIT(AreaUnit area) {
        assertThat(area.name()).endsWith("_UNIT");
    }

    @ParameterizedTest
    @MethodSource("provideAreaUnitFormattedSymbols")
    void testFormatUnitMethodOfAreaUnit(AreaUnit area, String expected) {
        assertThat(area.formatUnit()).isNotNull();
        assertThat(area.formatUnit()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideAreaUnitFormattedSymbols() {
        return Stream.of(
                arguments(SQUARE_METER_UNIT, "m²"),
                arguments(SQUARE_KILOMETER_UNIT, "km²"),
                arguments(SQUARE_MICROMETER_UNIT, "µm²"),
                arguments(HECTARE_UNIT, "ha"),
                arguments(SQUARE_MILE_UNIT, "mi²"),
                arguments(SQUARE_YARD_UNIT, "yd²"),
                arguments(SQUARE_FOOT_UNIT, "ft²"),
                arguments(SQUARE_INCH_UNIT, "in²"),
                arguments(ACRE_UNIT, "acre")
        );
    }

}