package com.ayo4u.metricsystem.config;

import com.ayo4u.metricsystem.model.temperature.TemperatureUnit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class StringToEnumConverter implements Converter<String, TemperatureUnit> {
    @Override
    public TemperatureUnit convert(String source) {
        return TemperatureUnit.valueOf(StringUtils.trimToEmpty(source).toUpperCase());
    }
}