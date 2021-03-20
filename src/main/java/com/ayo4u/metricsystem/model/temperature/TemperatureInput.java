package com.ayo4u.metricsystem.model.temperature;

import com.ayo4u.metricsystem.model.InputUnitBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class TemperatureInput extends InputUnitBase<TemperatureUnit> implements Serializable {
}
