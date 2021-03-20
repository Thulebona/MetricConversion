package com.ayo4u.metricsystem.service;

import com.ayo4u.metricsystem.model.OutputResponse;
import com.ayo4u.metricsystem.model.length.LengthInput;
import com.ayo4u.metricsystem.model.temperature.TemperatureInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static com.ayo4u.metricsystem.fatories.TestInputFactory.*;
import static com.ayo4u.metricsystem.model.length.LengthUnit.CENTIMETER_UNIT;
import static com.ayo4u.metricsystem.model.length.LengthUnit.METER_UNIT;
import static com.ayo4u.metricsystem.model.temperature.TemperatureUnit.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MetricConversionServiceTest {

    private MetricConversionService conversionService;

    @BeforeEach
    void setUp() {
        conversionService = new MetricConversionServiceImpl();
    }

    @Test
    void checkThatMockIsNotNull() {
        assertThat(conversionService).isNotNull();
    }

    private static Stream<Arguments> provideTemperatureInputsForConvertTemperatureTest() {
        return Stream.of(
                // from CELSIUS
                Arguments.of(getTemperatureInput(CELSIUS_UNIT, KELVIN_UNIT, 10), getExpected("283 K")),
                Arguments.of(getTemperatureInput(CELSIUS_UNIT, FAHRENHEIT_UNIT, 10), getExpected("50 °F")),
                //   from KELVIN
                Arguments.of(getTemperatureInput(KELVIN_UNIT, CELSIUS_UNIT, 283), getExpected("10 °C")),
                Arguments.of(getTemperatureInput(KELVIN_UNIT, FAHRENHEIT_UNIT, 10), getExpected("-442 °F")),
                //   from FAHRENHEIT
                Arguments.of(getTemperatureInput(FAHRENHEIT_UNIT, CELSIUS_UNIT, 50), getExpected("10 °C")),
                Arguments.of(getTemperatureInput(FAHRENHEIT_UNIT, KELVIN_UNIT, -442), getExpected("10 K")));
    }

    @ParameterizedTest
    @MethodSource("provideTemperatureInputsForConvertTemperatureTest")
    void convertTemperatureTest(TemperatureInput input, OutputResponse expected) {
        assertThat(conversionService.convertTemperature(input).getResult()).isEqualTo(expected.getResult());
        assertThat(conversionService.convertTemperature(input)).isOfAnyClassIn(OutputResponse.class);
    }

    private static Stream<Arguments> provideLengthInputsForConvertLengthTest() {
        return Stream.of(
                // from CENTIMETER
                Arguments.of(getLengthInput(CENTIMETER_UNIT, METER_UNIT, 1000), getExpected("10 m"))
        );
    }


    @ParameterizedTest
    @MethodSource("provideLengthInputsForConvertLengthTest")
    void convertLengthTest(LengthInput input, OutputResponse expected) {
        assertThat(conversionService.convertLength(input).getResult()).isEqualTo(expected.getResult());
        assertThat(conversionService.convertLength(input)).isOfAnyClassIn(OutputResponse.class);
    }

    @Test
    void convertArea() {
    }

    @Test
    void convertMassOrWeight() {
    }

    @Test
    void convertTimeOrClock() {
    }

    @Test
    void formatOutput() {
    }
}