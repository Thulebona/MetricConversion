package com.ayo4u.metricsystem.controller;

import com.ayo4u.metricsystem.model.InputUnitBase;
import com.ayo4u.metricsystem.model.OutputResponse;
import com.ayo4u.metricsystem.model.area.AreaInput;
import com.ayo4u.metricsystem.model.clock.TimeOrClockInput;
import com.ayo4u.metricsystem.model.length.LengthInput;
import com.ayo4u.metricsystem.model.temperature.TemperatureInput;
import com.ayo4u.metricsystem.model.weight.WeightInput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MetricConversionControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    private String url;


    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideTemperatureInputsForConvertTemperatureTest")
    void test_convertTemperatureITTest(TemperatureInput input, OutputResponse expected) throws Exception {
        url = "/temperature";
        assertExpectedResultsSame(input, expected);
    }

    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideLengthInputsForConvertLengthTest")
    void test_convertLength(LengthInput input, OutputResponse expected) throws JsonProcessingException {
        url = "/length";
        assertExpectedResultsSame(input, expected);
    }

    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideTimeOrClockInputsForConvertTimeOrClockTest")
    void test_convertTimeITTest(TimeOrClockInput input, OutputResponse expected) throws JsonProcessingException {
        url = "/time";
        assertExpectedResultsSame(input, expected);
    }

    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideMassOrWeightInputsForConvertMassOrWeightTest")
    void test_convertWeightITTest(WeightInput input, OutputResponse expected) throws JsonProcessingException {
        url = "/weight";
        assertExpectedResultsSame(input, expected);
    }


    @ParameterizedTest
    @MethodSource("com.ayo4u.metricsystem.utils.ParameterizedTestMethod#provideAreaInputsForConvertAreaTest")
    void test_convertAreaITTest(AreaInput input, OutputResponse expected) throws JsonProcessingException {
        url = "/area";
        assertExpectedResultsSame(input, expected);
    }

    private void assertExpectedResultsSame(InputUnitBase<?> inputRequest, OutputResponse expected) throws JsonProcessingException {
        String response = restTemplate.postForObject(url, inputRequest, String.class);

        assertThat(response)
                .isNotBlank()
                .isEqualTo(objectMapper.writeValueAsString(expected));
    }

}
