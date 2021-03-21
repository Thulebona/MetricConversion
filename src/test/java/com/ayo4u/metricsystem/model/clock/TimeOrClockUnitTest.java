package com.ayo4u.metricsystem.model.clock;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.ayo4u.metricsystem.model.clock.TimeOrClockUnit.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TimeOrClockUnitTest {

    @ParameterizedTest
    @EnumSource(TimeOrClockUnit.class)
    void testThatTimeOrClockUnitNameEndsWith__UNIT(TimeOrClockUnit unit) {
        assertThat(unit.name()).endsWith("_UNIT");
    }

    @ParameterizedTest
    @MethodSource("provideTimeOrClockFormattedSymbols")
    void testFormatUnitMethodOfTimeOrClock(TimeOrClockUnit unit, String expected) {
        assertThat(unit.formatUnit()).isNotNull();
        assertThat(unit.formatUnit()).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTimeOrClockFormattedSymbols() {
        return Stream.of(
                arguments(SECOND_UNIT, "s"),
                arguments(MINUTE_UNIT, "min"),
                arguments(HOUR_UNIT, "h"),
                arguments(DAY_UNIT, "day"),
                arguments(WEEK_UNIT, "week"),
                arguments(MONTH_UNIT, "month"),
                arguments(YEAR_UNIT, "year")
        );
    }

}