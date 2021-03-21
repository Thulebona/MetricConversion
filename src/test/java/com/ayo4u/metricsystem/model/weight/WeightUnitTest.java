package com.ayo4u.metricsystem.model.weight;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ayo4u.metricsystem.model.weight.WeightUnit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WeightUnitTest {
    @ParameterizedTest
    @EnumSource(WeightUnit.class)
    void testThatWeightUnitNameEndsWith__UNIT(WeightUnit unit) {
        assertThat(unit.name()).endsWith("_UNIT");
    }

    @ParameterizedTest
    @MethodSource("provideWeightUnitFormattedSymbols")
    void testFormatUnitMethodOfWeightUnit(WeightUnit unit, String expected) {
        assertThat(unit.formatUnit()).isNotNull();
        assertThat(unit.formatUnit()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWeightUnitFormattedSymbols() {
        return Stream.of(
                arguments(GRAM_UNIT, "g"),
                arguments(KILOGRAM_UNIT, "kg"),
                arguments(MILLIGRAM_UNIT, "mg"),
                arguments(METRICTON_US_UNIT, "ton_us"),
                arguments(METRICTON_UK_UNIT, "ton_uk"),
                arguments(POUND_UNIT, "lb"),
                arguments(CARAT_UNIT, "ct"),
                arguments(OUNCE_UNIT, "oz")
        );
    }
}