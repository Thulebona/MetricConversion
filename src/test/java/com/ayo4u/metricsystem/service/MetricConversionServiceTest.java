package com.ayo4u.metricsystem.service;

import com.ayo4u.metricsystem.model.OutputResponse;
import com.ayo4u.metricsystem.model.area.AreaInput;
import com.ayo4u.metricsystem.model.clock.TimeOrClockInput;
import com.ayo4u.metricsystem.model.length.LengthInput;
import com.ayo4u.metricsystem.model.temperature.TemperatureInput;
import com.ayo4u.metricsystem.model.weight.WeightInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MetricConversionServiceTest {


    private MetricConversionService conversionService;

    @BeforeEach
    void setUp() {
        conversionService = new MetricConversionServiceImpl();
        ReflectionTestUtils.setField(conversionService, "maxFractionDigits", 6);
    }

    @Test
    void checkThatMockIsNotNull() {
        assertThat(conversionService).isNotNull();
    }


    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideTemperatureInputsForConvertTemperatureTest")
    void convertTemperatureTest(TemperatureInput input, OutputResponse expected) {
        assertThat(conversionService.convertTemperature(input)).isOfAnyClassIn(OutputResponse.class);
        assertThat(conversionService.convertTemperature(input).getResult()).isEqualTo(expected.getResult());
    }


    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideLengthInputsForConvertLengthTest")
    void convertLengthTest(LengthInput input, OutputResponse expected) {
        assertThat(conversionService.convertLength(input)).isOfAnyClassIn(OutputResponse.class);
        assertThat(conversionService.convertLength(input).getResult()).isEqualTo(expected.getResult());
    }

    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideAreaInputsForConvertAreaTest")
    void convertAreaTest(AreaInput input, OutputResponse expected) {
        assertThat(conversionService.convertArea(input)).isOfAnyClassIn(OutputResponse.class);
        assertThat(conversionService.convertArea(input).getResult()).isEqualTo(expected.getResult());

    }

    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideMassOrWeightInputsForConvertMassOrWeightTest")
    void convertMassOrWeight(WeightInput input, OutputResponse expected) {
        assertThat(conversionService.convertMassOrWeight(input)).isOfAnyClassIn(OutputResponse.class);
        assertThat(conversionService.convertMassOrWeight(input).getResult()).isEqualTo(expected.getResult());
    }

    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideTimeOrClockInputsForConvertTimeOrClockTest")
    void convertTimeOrClockTest(TimeOrClockInput input, OutputResponse expected) {
        assertThat(conversionService.convertTimeOrClock(input)).isOfAnyClassIn(OutputResponse.class);
        assertThat(conversionService.convertTimeOrClock(input).getResult()).isEqualTo(expected.getResult());
    }

    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideTest_formatOutputWithMaxFractionDigits")
    void test_formatOutputWithMaxFractionDigits(double result, int maxFraction, String symbol, String output) {
        ReflectionTestUtils.setField(conversionService, "result", result);
        ReflectionTestUtils.setField(conversionService, "maxFractionDigits", maxFraction);
        assertThat(conversionService.formatOutput(symbol).getResult()).isEqualTo(output);
    }


}