package com.ayo4u.metricsystem.utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static com.ayo4u.metricsystem.fatories.TestInputFactory.*;
import static com.ayo4u.metricsystem.model.area.AreaUnit.*;
import static com.ayo4u.metricsystem.model.clock.TimeOrClockUnit.*;
import static com.ayo4u.metricsystem.model.length.LengthUnit.*;
import static com.ayo4u.metricsystem.model.temperature.TemperatureUnit.*;
import static com.ayo4u.metricsystem.model.weight.WeightUnit.*;

public class ParameterizedTestMethod {

    static Stream<Arguments> provideTemperatureInputsForConvertTemperatureTest() {
        return Stream.of(
                // from CELSIUS
                Arguments.of(getTemperatureInput(CELSIUS_UNIT, KELVIN_UNIT, 10), getExpected("283.15 K")),
                Arguments.of(getTemperatureInput(CELSIUS_UNIT, FAHRENHEIT_UNIT, 10), getExpected("50 °F")),
                //   from KELVIN
                Arguments.of(getTemperatureInput(KELVIN_UNIT, CELSIUS_UNIT, 283), getExpected("9.85 °C")),
                Arguments.of(getTemperatureInput(KELVIN_UNIT, FAHRENHEIT_UNIT, 10), getExpected("-441.67 °F")),
                //   from FAHRENHEIT
                Arguments.of(getTemperatureInput(FAHRENHEIT_UNIT, CELSIUS_UNIT, 50), getExpected("10 °C")),
                Arguments.of(getTemperatureInput(FAHRENHEIT_UNIT, KELVIN_UNIT, -441.67), getExpected("10 K")));
    }


    static Stream<Arguments> provideLengthInputsForConvertLengthTest() {
        return Stream.of(
                //  METER_UNIT & CENTIMETER
                Arguments.of(getLengthInput(CENTIMETER_UNIT, METER_UNIT, 1000), getExpected("10 m")),
                Arguments.of(getLengthInput(METER_UNIT, CENTIMETER_UNIT, 10), getExpected("1000 cm")),
                //  FOOT_UNIT & KILOMETER_UNIT
                Arguments.of(getLengthInput(KILOMETER_UNIT, FOOT_UNIT, 1000), getExpected("3280839.895013 ft")),
                Arguments.of(getLengthInput(FOOT_UNIT, KILOMETER_UNIT, 3280839.895013), getExpected("1000 km")),
                //  LIGHT_YEAR_UNIT & KILOMETER_UNIT
                Arguments.of(getLengthInput(LIGHT_YEAR_UNIT, INCH_UNIT, 0.001), getExpected("372461748228346.44 in")),
                Arguments.of(getLengthInput(INCH_UNIT, LIGHT_YEAR_UNIT, 372461748228346.44), getExpected("0.001 ly")),
                //  METER_UNIT & MILE_UNIT
                Arguments.of(getLengthInput(MILE_UNIT, METER_UNIT, 1000), getExpected("1609344 m")),
                Arguments.of(getLengthInput(METER_UNIT, MILE_UNIT, 10), getExpected("0.006214 mi"))
        );
    }

    static Stream<Arguments> provideAreaInputsForConvertAreaTest() {
        return Stream.of(
                Arguments.of(getAreaInput(SQUARE_METER_UNIT, HECTARE_UNIT, 10), getExpected("0.001 ha")),
                Arguments.of(getAreaInput(HECTARE_UNIT, SQUARE_KILOMETER_UNIT, 0.001), getExpected("0.00001 km²")),

                Arguments.of(getAreaInput(SQUARE_INCH_UNIT, SQUARE_MICROMETER_UNIT, 1), getExpected("645160000 µm²")),
                Arguments.of(getAreaInput(SQUARE_MICROMETER_UNIT, SQUARE_INCH_UNIT, 645160000), getExpected("1 in²")),

                Arguments.of(getAreaInput(SQUARE_MILE_UNIT, SQUARE_YARD_UNIT, 5), getExpected("15488000 yd²")),
                Arguments.of(getAreaInput(SQUARE_YARD_UNIT, SQUARE_MILE_UNIT, 15488000), getExpected("5 mi²")),

                Arguments.of(getAreaInput(ACRE_UNIT, SQUARE_FOOT_UNIT, 10), getExpected("435615.454564 ft²")),
                Arguments.of(getAreaInput(SQUARE_FOOT_UNIT, ACRE_UNIT, 435615.454564), getExpected("10 acre"))
        );
    }


    static Stream<Arguments> provideMassOrWeightInputsForConvertMassOrWeightTest() {
        return Stream.of(
                Arguments.of(getWeightInput(GRAM_UNIT, MILLIGRAM_UNIT, 10), getExpected("10000 mg")),
                Arguments.of(getWeightInput(MILLIGRAM_UNIT, GRAM_UNIT, 10000), getExpected("10 g")),

                Arguments.of(getWeightInput(KILOGRAM_UNIT, METRICTON_US_UNIT, 10), getExpected("0.011023 ton_us")),
                Arguments.of(getWeightInput(METRICTON_US_UNIT, KILOGRAM_UNIT, 0.011023), getExpected("9.999897 kg")),

                Arguments.of(getWeightInput(METRICTON_UK_UNIT, CARAT_UNIT, 10), getExpected("50802345.44 ct")),
                Arguments.of(getWeightInput(CARAT_UNIT, METRICTON_UK_UNIT, 50802345.44), getExpected("10 ton_uk")),

                Arguments.of(getWeightInput(POUND_UNIT, OUNCE_UNIT, 10), getExpected("160 oz")),
                Arguments.of(getWeightInput(OUNCE_UNIT, POUND_UNIT, 160), getExpected("10 lb"))

        );
    }

    static Stream<Arguments> provideTest_formatOutputWithMaxFractionDigits() {
        return Stream.of(
                Arguments.of(20, 4, "kg", "20 kg"),
                Arguments.of(0.789, 0, "ton_uk", "1 ton_uk"),
                Arguments.of(20.455564, 2, "ft²", "20.46 ft²")
        );
    }

    static Stream<Arguments> provideTimeOrClockInputsForConvertTimeOrClockTest() {
        return Stream.of(
                Arguments.of(getTimeOrClockInput(SECOND_UNIT, HOUR_UNIT, 10), getExpected("0.002778 h")),
                Arguments.of(getTimeOrClockInput(HOUR_UNIT, SECOND_UNIT, 0.002778), getExpected("10.0008 s")),

                Arguments.of(getTimeOrClockInput(SECOND_UNIT, MINUTE_UNIT, 10), getExpected("0.166667 min")),
                Arguments.of(getTimeOrClockInput(MINUTE_UNIT, SECOND_UNIT, 0.166667), getExpected("10.00002 s")),

                Arguments.of(getTimeOrClockInput(DAY_UNIT, MONTH_UNIT, 10), getExpected("0.328767 month")),
                Arguments.of(getTimeOrClockInput(MONTH_UNIT, DAY_UNIT, 0.328767), getExpected("10.000001 day")),

                Arguments.of(getTimeOrClockInput(WEEK_UNIT, YEAR_UNIT, 10), getExpected("0.191648 year")),
                Arguments.of(getTimeOrClockInput(YEAR_UNIT, WEEK_UNIT, 0.191648), getExpected("9.999987 week"))
        );
    }


}
