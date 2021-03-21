package com.ayo4u.metricsystem.model.temperature;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.stream.Stream;

import static com.ayo4u.metricsystem.model.temperature.TemperatureUnit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TemperatureUnitTest {


    @ParameterizedTest
    @EnumSource(TemperatureUnit.class)
    void testThatTemperatureUnitNameEndsWith__UNIT(TemperatureUnit unit) {
        assertThat(unit.name()).endsWith("_UNIT");
    }

    @ParameterizedTest
    @MethodSource("provideTemperatureUnitFormattedSymbols")
    void testFormatUnitMethodOfTemperatureUnit(TemperatureUnit unit, String expected) {
        assertThat(unit.formatUnit()).isNotNull();
        assertThat(unit.formatUnit()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTemperatureUnitFormattedSymbols() {
        return Stream.of(
                arguments(CELSIUS_UNIT, "°C"),
                arguments(KELVIN_UNIT, "K"),
                arguments(FAHRENHEIT_UNIT, "°F")
        );
    }
}