package com.ayo4u.metricsystem.model.length;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ayo4u.metricsystem.model.length.LengthUnit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LengthUnitTest {
    @ParameterizedTest
    @EnumSource(LengthUnit.class)
    void testThatLengthUnitNameEndsWith__UNIT(LengthUnit unit) {
        assertThat(unit.name()).endsWith("_UNIT");
    }

    @ParameterizedTest
    @MethodSource("provideLengthUnitFormattedSymbols")
    void testFormatUnitMethodOfLengthUnit(LengthUnit unit, String expected) {
        assertThat(unit.formatUnit()).isNotNull();
        assertThat(unit.formatUnit()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLengthUnitFormattedSymbols() {
        return Stream.of(
                arguments(METER_UNIT, "m"),
                arguments(KILOMETER_UNIT, "km"),
                arguments(CENTIMETER_UNIT, "cm"),
                arguments(MILLIMETER_UNIT, "mm"),
                arguments(MILE_UNIT, "mi"),
                arguments(YARD_UNIT, "yd"),
                arguments(FOOT_UNIT, "ft"),
                arguments(INCH_UNIT, "in"),
                arguments(LIGHT_YEAR_UNIT, "ly")
        );
    }
}